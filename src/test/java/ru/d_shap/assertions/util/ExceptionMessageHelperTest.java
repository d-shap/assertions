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

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ExceptionMessageHelper}.
 *
 * @author Dmitry Shapovalov
 */
public final class ExceptionMessageHelperTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ExceptionMessageHelperTest() {
        super();
    }

    /**
     * {@link ExceptionMessageHelper} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(ExceptionMessageHelper.class).hasOnePrivateConstructor();
    }

    /**
     * {@link ExceptionMessageHelper} class test.
     */
    @Test
    public void getMessageTest() {
        Assertions.assertThat(ExceptionMessageHelper.getMessage(null)).isNull();

        Assertions.assertThat(ExceptionMessageHelper.getMessage(new IOException())).isNull();
        Assertions.assertThat(ExceptionMessageHelper.getMessage(new IOException(new UnsupportedEncodingException()))).isEqualTo("java.io.UnsupportedEncodingException");

        Assertions.assertThat(ExceptionMessageHelper.getMessage(new IOException("message"))).isEqualTo("message");
        Assertions.assertThat(ExceptionMessageHelper.getMessage(new IOException(new UnsupportedEncodingException("message")))).isEqualTo("java.io.UnsupportedEncodingException: message");
        Assertions.assertThat(ExceptionMessageHelper.getMessage(new IOException("message", new UnsupportedEncodingException()))).isEqualTo("message");
        Assertions.assertThat(ExceptionMessageHelper.getMessage(new IOException("message", new UnsupportedEncodingException("message")))).isEqualTo("message");
    }

}
