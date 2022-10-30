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
package ru.d_shap.assertions.util;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.mock.IsCloseable;

/**
 * Tests for {@link IOStreamHelper}.
 *
 * @author Dmitry Shapovalov
 */
public final class IOStreamHelperTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IOStreamHelperTest() {
        super();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(IOStreamHelper.class).hasOnePrivateConstructor();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsBytesCloseByDefaultTest() {
        Assertions.assertThat(IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).buildInputStream())).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(-5, 10, -15, 20, 0, 5).buildInputStream())).containsExactlyInOrder(-5, 10, -15, 20, 0, 5);

        try {
            IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).setReadException("fail").buildInputStream());
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).setCloseException("fail").buildInputStream());
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).setReadException("fail 1").setCloseException("fail 2").buildInputStream());
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail 2");
        }

        InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(1, 2, 3).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsBytes(inputStream)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(((IsCloseable) inputStream).isClosed()).isTrue();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsBytesTest() {
        Assertions.assertThat(IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).buildInputStream(), true)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).buildInputStream(), false)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(-5, 10, -15, 20, 0, 5).buildInputStream(), true)).containsExactlyInOrder(-5, 10, -15, 20, 0, 5);
        Assertions.assertThat(IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(-5, 10, -15, 20, 0, 5).buildInputStream(), false)).containsExactlyInOrder(-5, 10, -15, 20, 0, 5);
        Assertions.assertThat(IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).setCloseException("fail").buildInputStream(), false)).containsExactlyInOrder(1, 2, 3);

        try {
            IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).setReadException("fail").buildInputStream(), true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).setReadException("fail").buildInputStream(), false);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).setCloseException("fail").buildInputStream(), true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).setReadException("fail 1").setCloseException("fail 2").buildInputStream(), true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail 2");
        }
        try {
            IOStreamHelper.readAsBytes(DataHelper.createInputStreamBuilder().setContent(1, 2, 3).setReadException("fail 1").setCloseException("fail 2").buildInputStream(), false);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail 1");
        }

        InputStream inputStream1 = DataHelper.createInputStreamBuilder().setContent(1, 2, 3).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsBytes(inputStream1, true)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(((IsCloseable) inputStream1).isClosed()).isTrue();

        InputStream inputStream2 = DataHelper.createInputStreamBuilder().setContent(1, 2, 3).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsBytes(inputStream2, false)).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(((IsCloseable) inputStream2).isClosed()).isFalse();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsCharsCloseByDefaultTest() {
        Assertions.assertThat(IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader())).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('a', 0, 125, 'c').buildReader())).containsExactlyInOrder('a', 0, 125, 'c');

        try {
            IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').setReadException("fail").buildReader());
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').setCloseException("fail").buildReader());
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').setReadException("fail 1").setCloseException("fail 2").buildReader());
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail 2");
        }

        Reader reader = DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader();
        Assertions.assertThat(IOStreamHelper.readAsChars(reader)).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(((IsCloseable) reader).isClosed()).isTrue();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsCharsTest() {
        Assertions.assertThat(IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader(), true)).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader(), false)).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('a', 0, 125, 'c').buildReader(), true)).containsExactlyInOrder('a', 0, 125, 'c');
        Assertions.assertThat(IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('a', 0, 125, 'c').buildReader(), false)).containsExactlyInOrder('a', 0, 125, 'c');
        Assertions.assertThat(IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').setCloseException("fail").buildReader(), false)).containsExactlyInOrder('1', '2', '3');

        try {
            IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').setReadException("fail").buildReader(), true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').setReadException("fail").buildReader(), false);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').setCloseException("fail").buildReader(), true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').setReadException("fail 1").setCloseException("fail 2").buildReader(), true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail 2");
        }
        try {
            IOStreamHelper.readAsChars(DataHelper.createReaderBuilder().setContent('1', '2', '3').setReadException("fail 1").setCloseException("fail 2").buildReader(), false);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail 1");
        }

        Reader reader1 = DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader();
        Assertions.assertThat(IOStreamHelper.readAsChars(reader1, true)).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(((IsCloseable) reader1).isClosed()).isTrue();

        Reader reader2 = DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader();
        Assertions.assertThat(IOStreamHelper.readAsChars(reader2, false)).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(((IsCloseable) reader2).isClosed()).isFalse();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringInputStreamCharsetCloseByDefaultTest() {
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), StandardCharsets.UTF_8)).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), StandardCharsets.US_ASCII)).isEqualTo("value");

        InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsString(inputStream, StandardCharsets.UTF_8)).isEqualTo("test");
        Assertions.assertThat(((IsCloseable) inputStream).isClosed()).isTrue();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringInputStreamCharsetTest() {
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), StandardCharsets.UTF_8, true)).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), StandardCharsets.UTF_8, false)).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), StandardCharsets.US_ASCII, true)).isEqualTo("value");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), StandardCharsets.US_ASCII, false)).isEqualTo("value");

        InputStream inputStream1 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsString(inputStream1, StandardCharsets.UTF_8, true)).isEqualTo("test");
        Assertions.assertThat(((IsCloseable) inputStream1).isClosed()).isTrue();

        InputStream inputStream2 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsString(inputStream2, StandardCharsets.UTF_8, false)).isEqualTo("test");
        Assertions.assertThat(((IsCloseable) inputStream2).isClosed()).isFalse();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringInputStreamCharsetNameCloseByDefaultTest() {
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "UTF-8")).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), "ISO-8859-1")).isEqualTo("value");

        try {
            IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "wrong encoding");
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasCause(UnsupportedEncodingException.class);
        }

        InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsString(inputStream, "UTF-8")).isEqualTo("test");
        Assertions.assertThat(((IsCloseable) inputStream).isClosed()).isTrue();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringInputStreamCharsetNameTest() {
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "UTF-8", true)).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "UTF-8", false)).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), "ISO-8859-1", true)).isEqualTo("value");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), "ISO-8859-1", false)).isEqualTo("value");

        try {
            IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "wrong encoding", true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasCause(UnsupportedEncodingException.class);
        }
        try {
            IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "wrong encoding", false);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasCause(UnsupportedEncodingException.class);
        }

        InputStream inputStream1 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsString(inputStream1, "UTF-8", true)).isEqualTo("test");
        Assertions.assertThat(((IsCloseable) inputStream1).isClosed()).isTrue();

        InputStream inputStream2 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsString(inputStream2, "UTF-8", false)).isEqualTo("test");
        Assertions.assertThat(((IsCloseable) inputStream2).isClosed()).isFalse();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringReaderCloseByDefaultTest() {
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader())).isEqualTo("123");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createReaderBuilder().setContent('a', 0, 125, 'c').buildReader())).isEqualTo("a\u0000}c");

        Reader reader = DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader();
        Assertions.assertThat(IOStreamHelper.readAsString(reader)).isEqualTo("123");
        Assertions.assertThat(((IsCloseable) reader).isClosed()).isTrue();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringReaderTest() {
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader(), true)).isEqualTo("123");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader(), false)).isEqualTo("123");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createReaderBuilder().setContent('a', 0, 125, 'c').buildReader(), true)).isEqualTo("a\u0000}c");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createReaderBuilder().setContent('a', 0, 125, 'c').buildReader(), false)).isEqualTo("a\u0000}c");

        Reader reader1 = DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader();
        Assertions.assertThat(IOStreamHelper.readAsString(reader1, true)).isEqualTo("123");
        Assertions.assertThat(((IsCloseable) reader1).isClosed()).isTrue();

        Reader reader2 = DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader();
        Assertions.assertThat(IOStreamHelper.readAsString(reader2, false)).isEqualTo("123");
        Assertions.assertThat(((IsCloseable) reader2).isClosed()).isFalse();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsUtf8StringCloseByDefaultTest() {
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream())).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream())).isEqualTo("value");

        InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(inputStream)).isEqualTo("test");
        Assertions.assertThat(((IsCloseable) inputStream).isClosed()).isTrue();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsUtf8StringTest() {
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), true)).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), false)).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), true)).isEqualTo("value");
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), false)).isEqualTo("value");

        InputStream inputStream1 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(inputStream1, true)).isEqualTo("test");
        Assertions.assertThat(((IsCloseable) inputStream1).isClosed()).isTrue();

        InputStream inputStream2 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(inputStream2, false)).isEqualTo("test");
        Assertions.assertThat(((IsCloseable) inputStream2).isClosed()).isFalse();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringsInputStreamCharsetCloseByDefaultTest() {
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().buildInputStream(), StandardCharsets.UTF_8)).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), StandardCharsets.UTF_8)).containsExactlyInOrder("test");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), StandardCharsets.US_ASCII)).containsExactlyInOrder("value");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value1\nvalue2\nvalue3").buildInputStream(), StandardCharsets.US_ASCII)).containsExactlyInOrder("value1", "value2", "value3");

        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).setReadException("fail").buildInputStream(), StandardCharsets.UTF_8);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).setCloseException("fail").buildInputStream(), StandardCharsets.UTF_8);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).setReadException("fail 1").setCloseException("fail 2").buildInputStream(), StandardCharsets.UTF_8);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail 2");
        }

        InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsStrings(inputStream, StandardCharsets.UTF_8)).containsExactlyInOrder("test");
        Assertions.assertThat(((IsCloseable) inputStream).isClosed()).isTrue();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringsInputStreamCharsetTest() {
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().buildInputStream(), StandardCharsets.UTF_8, true)).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().buildInputStream(), StandardCharsets.UTF_8, false)).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), StandardCharsets.UTF_8, true)).containsExactlyInOrder("test");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), StandardCharsets.UTF_8, false)).containsExactlyInOrder("test");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), StandardCharsets.US_ASCII, true)).containsExactlyInOrder("value");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), StandardCharsets.US_ASCII, false)).containsExactlyInOrder("value");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value1\nvalue2\nvalue3").buildInputStream(), StandardCharsets.US_ASCII, true)).containsExactlyInOrder("value1", "value2", "value3");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value1\nvalue2\nvalue3").buildInputStream(), StandardCharsets.US_ASCII, false)).containsExactlyInOrder("value1", "value2", "value3");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).setCloseException("fail").buildInputStream(), StandardCharsets.UTF_8, false)).containsExactlyInOrder("test");

        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).setReadException("fail").buildInputStream(), StandardCharsets.UTF_8, true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).setReadException("fail").buildInputStream(), StandardCharsets.UTF_8, false);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).setCloseException("fail").buildInputStream(), StandardCharsets.UTF_8, true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).setReadException("fail 1").setCloseException("fail 2").buildInputStream(), StandardCharsets.UTF_8, true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail 2");
        }
        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).setReadException("fail 1").setCloseException("fail 2").buildInputStream(), StandardCharsets.UTF_8, false);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasMessage("fail 1");
        }

        InputStream inputStream1 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsStrings(inputStream1, StandardCharsets.UTF_8, true)).containsExactlyInOrder("test");
        Assertions.assertThat(((IsCloseable) inputStream1).isClosed()).isTrue();

        InputStream inputStream2 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsStrings(inputStream2, StandardCharsets.UTF_8, false)).containsExactlyInOrder("test");
        Assertions.assertThat(((IsCloseable) inputStream2).isClosed()).isFalse();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringsInputStreamCharsetNameCloseByDefaultTest() {
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().buildInputStream(), "UTF-8")).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "UTF-8")).containsExactlyInOrder("test");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), "ISO-8859-1")).containsExactlyInOrder("value");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value1\nvalue2\nvalue3").buildInputStream(), "ISO-8859-1")).containsExactlyInOrder("value1", "value2", "value3");

        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "wrong encoding");
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasCause(UnsupportedEncodingException.class);
        }

        InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsStrings(inputStream, "UTF-8")).containsExactlyInOrder("test");
        Assertions.assertThat(((IsCloseable) inputStream).isClosed()).isTrue();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringsInputStreamCharsetNameTest() {
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().buildInputStream(), "UTF-8", true)).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().buildInputStream(), "UTF-8", false)).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "UTF-8", true)).containsExactlyInOrder("test");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "UTF-8", false)).containsExactlyInOrder("test");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), "ISO-8859-1", true)).containsExactlyInOrder("value");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), "ISO-8859-1", false)).containsExactlyInOrder("value");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value1\nvalue2\nvalue3").buildInputStream(), "ISO-8859-1", true)).containsExactlyInOrder("value1", "value2", "value3");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent("value1\nvalue2\nvalue3").buildInputStream(), "ISO-8859-1", false)).containsExactlyInOrder("value1", "value2", "value3");

        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "wrong encoding", true);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasCause(UnsupportedEncodingException.class);
        }
        try {
            IOStreamHelper.readAsStrings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "wrong encoding", false);
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasCause(UnsupportedEncodingException.class);
        }

        InputStream inputStream1 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsStrings(inputStream1, "UTF-8", true)).containsExactlyInOrder("test");
        Assertions.assertThat(((IsCloseable) inputStream1).isClosed()).isTrue();

        InputStream inputStream2 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsStrings(inputStream2, "UTF-8", false)).containsExactlyInOrder("test");
        Assertions.assertThat(((IsCloseable) inputStream2).isClosed()).isFalse();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringsReaderCloseByDefaultTest() {
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().buildReader())).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader())).containsExactlyInOrder("123");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().setContent('a', 0, 125, 'c').buildReader())).containsExactlyInOrder("a\u0000}c");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().setContent('a', 'b', 'c', '\n', 'd', 'e', '\n', 'f').buildReader())).containsExactlyInOrder("abc", "de", "f");

        Reader reader = DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader();
        Assertions.assertThat(IOStreamHelper.readAsStrings(reader)).containsExactlyInOrder("123");
        Assertions.assertThat(((IsCloseable) reader).isClosed()).isTrue();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringsReaderTest() {
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().buildReader(), true)).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().buildReader(), false)).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader(), true)).containsExactlyInOrder("123");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader(), false)).containsExactlyInOrder("123");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().setContent('a', 0, 125, 'c').buildReader(), true)).containsExactlyInOrder("a\u0000}c");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().setContent('a', 0, 125, 'c').buildReader(), false)).containsExactlyInOrder("a\u0000}c");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().setContent('a', 'b', 'c', '\n', 'd', 'e', '\n', 'f').buildReader(), true)).containsExactlyInOrder("abc", "de", "f");
        Assertions.assertThat(IOStreamHelper.readAsStrings(DataHelper.createReaderBuilder().setContent('a', 'b', 'c', '\n', 'd', 'e', '\n', 'f').buildReader(), false)).containsExactlyInOrder("abc", "de", "f");

        Reader reader1 = DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader();
        Assertions.assertThat(IOStreamHelper.readAsStrings(reader1, true)).containsExactlyInOrder("123");
        Assertions.assertThat(((IsCloseable) reader1).isClosed()).isTrue();

        Reader reader2 = DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader();
        Assertions.assertThat(IOStreamHelper.readAsStrings(reader2, false)).containsExactlyInOrder("123");
        Assertions.assertThat(((IsCloseable) reader2).isClosed()).isFalse();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsUtf8StringsCloseByDefaultTest() {
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().buildInputStream())).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream())).containsExactlyInOrder("test");
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream())).containsExactlyInOrder("value");
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().setContent("value1\nvalue2\nvalue3").buildInputStream())).containsExactlyInOrder("value1", "value2", "value3");

        InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(inputStream)).containsExactlyInOrder("test");
        Assertions.assertThat(((IsCloseable) inputStream).isClosed()).isTrue();
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsUtf8StringsTest() {
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().buildInputStream(), true)).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().buildInputStream(), false)).containsExactlyInOrder();
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), true)).containsExactlyInOrder("test");
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), false)).containsExactlyInOrder("test");
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), true)).containsExactlyInOrder("value");
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), false)).containsExactlyInOrder("value");
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().setContent("value1\nvalue2\nvalue3").buildInputStream(), true)).containsExactlyInOrder("value1", "value2", "value3");
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(DataHelper.createInputStreamBuilder().setContent("value1\nvalue2\nvalue3").buildInputStream(), false)).containsExactlyInOrder("value1", "value2", "value3");

        InputStream inputStream1 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(inputStream1, true)).containsExactlyInOrder("test");
        Assertions.assertThat(((IsCloseable) inputStream1).isClosed()).isTrue();

        InputStream inputStream2 = DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream();
        Assertions.assertThat(IOStreamHelper.readAsUtf8Strings(inputStream2, false)).containsExactlyInOrder("test");
        Assertions.assertThat(((IsCloseable) inputStream2).isClosed()).isFalse();
    }

}
