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
package ru.d_shap.assertions.converter;

import java.io.IOException;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ConversionException}.
 *
 * @author Dmitry Shapovalov
 */
public final class ConversionExceptionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ConversionExceptionTest() {
        super();
    }

    /**
     * {@link ConversionException} class test.
     */
    @Test
    public void conversionExceptionCauseTest() {
        Assertions.assertThat(new ConversionException(null)).isNotNull();
        Assertions.assertThat(new ConversionException(null)).isInstanceOf(ConversionException.class);
        Assertions.assertThat(new ConversionException(null)).messageIsNull();
        Assertions.assertThat(new ConversionException(null)).causeIsNull();

        Assertions.assertThat(new ConversionException(new IOException())).isNotNull();
        Assertions.assertThat(new ConversionException(new IOException())).isInstanceOf(ConversionException.class);
        Assertions.assertThat(new ConversionException(new IOException())).hasMessage("java.io.IOException");
        Assertions.assertThat(new ConversionException(new IOException())).hasCause(IOException.class);
        Assertions.assertThat(new ConversionException(new IOException())).causeMessageIsNull();

        Assertions.assertThat(new ConversionException(new IOException("exception"))).isNotNull();
        Assertions.assertThat(new ConversionException(new IOException("exception"))).isInstanceOf(ConversionException.class);
        Assertions.assertThat(new ConversionException(new IOException("exception"))).hasMessage("java.io.IOException: exception");
        Assertions.assertThat(new ConversionException(new IOException("exception"))).hasCause(IOException.class);
        Assertions.assertThat(new ConversionException(new IOException("exception"))).hasCauseMessage("exception");
    }

}
