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

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Helper class to perform IO operations.
 *
 * @author Dmitry Shapovalov
 */
public final class IOStreamHelper {

    private static final int BUFFER_SIZE = 500;

    private IOStreamHelper() {
        super();
    }

    public static byte[] readAsBytes(final InputStream inputStream) {
        try {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[BUFFER_SIZE];
                int read;
                while (true) {
                    read = inputStream.read(buffer);
                    if (read <= 0) {
                        break;
                    }
                    baos.write(buffer, 0, read);
                }
                return baos.toByteArray();
            } finally {
                inputStream.close();
            }
        } catch (IOException ex) {
            throw new IOStreamException(ex);
        }
    }

    public static char[] readAsChars(final Reader reader) {
        try {
            try {
                CharArrayWriter caw = new CharArrayWriter();
                char[] buffer = new char[BUFFER_SIZE];
                int read;
                while (true) {
                    read = reader.read(buffer);
                    if (read <= 0) {
                        break;
                    }
                    caw.write(buffer, 0, read);
                }
                return caw.toCharArray();
            } finally {
                reader.close();
            }
        } catch (IOException ex) {
            throw new IOStreamException(ex);
        }
    }

    public static String readAsString(final InputStream inputStream, final Charset charset) {
        byte[] bytes = readAsBytes(inputStream);
        return new String(bytes, charset);
    }

    public static String readAsString(final InputStream inputStream, final String charsetName) {
        try {
            byte[] bytes = readAsBytes(inputStream);
            return new String(bytes, charsetName);
        } catch (IOException ex) {
            throw new IOStreamException(ex);
        }
    }

    public static String readAsString(final Reader reader) {
        char[] chars = readAsChars(reader);
        return new String(chars);
    }

    public static String readAsUtf8String(final InputStream inputStream) {
        return readAsString(inputStream, StandardCharsets.UTF_8);
    }

}
