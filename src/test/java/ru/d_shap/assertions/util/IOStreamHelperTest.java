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
    public void readAsBytesTest() {
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
    public void readAsCharsTest() {
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
    public void readAsStringInputStreamCharsetTest() {
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), StandardCharsets.UTF_8)).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), StandardCharsets.US_ASCII)).isEqualTo("value");
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringInputStreamCharsetNameTest() {
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "UTF-8")).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream(), "ISO-8859-1")).isEqualTo("value");

        try {
            IOStreamHelper.readAsString(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream(), "wrong encoding");
            Assertions.fail("IOStreamHelper test fail");
        } catch (IOStreamException ex) {
            Assertions.assertThat(ex).hasCause(UnsupportedEncodingException.class);
        }
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsStringReaderTest() {
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createReaderBuilder().setContent('1', '2', '3').buildReader())).isEqualTo("123");
        Assertions.assertThat(IOStreamHelper.readAsString(DataHelper.createReaderBuilder().setContent('a', 0, 125, 'c').buildReader())).isEqualTo("a\u0000}c");
    }

    /**
     * {@link IOStreamHelper} class test.
     */
    @Test
    public void readAsUtf8StringTest() {
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(DataHelper.createInputStreamBuilder().setContent(116, 101, 115, 116).buildInputStream())).isEqualTo("test");
        Assertions.assertThat(IOStreamHelper.readAsUtf8String(DataHelper.createInputStreamBuilder().setContent("value").buildInputStream())).isEqualTo("value");
    }

}
