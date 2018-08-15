///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
//
// Assertions framework is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests for {@link ConvertionException}.
 *
 * @author Dmitry Shapovalov
 */
public final class ConvertionExceptionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ConvertionExceptionTest() {
        super();
    }

    /**
     * {@link ConvertionException} class test.
     */
    @Test
    public void causeTest() {
        Assertions.assertThat(new ConvertionException(null)).isNotNull();
        Assertions.assertThat(new ConvertionException(null)).isInstanceOf(ConvertionException.class);
        Assertions.assertThat(new ConvertionException(null)).toMessage().isNull();
        Assertions.assertThat(new ConvertionException(null)).toCause().isNull();

        Assertions.assertThat(new ConvertionException(new IOException())).isNotNull();
        Assertions.assertThat(new ConvertionException(new IOException())).isInstanceOf(ConvertionException.class);
        Assertions.assertThat(new ConvertionException(new IOException())).hasMessage("java.io.IOException");
        Assertions.assertThat(new ConvertionException(new IOException())).hasCause(IOException.class);
        Assertions.assertThat(new ConvertionException(new IOException())).toCause().toMessage().isNull();

        Assertions.assertThat(new ConvertionException(new IOException("exception"))).isNotNull();
        Assertions.assertThat(new ConvertionException(new IOException("exception"))).isInstanceOf(ConvertionException.class);
        Assertions.assertThat(new ConvertionException(new IOException("exception"))).hasMessage("java.io.IOException: exception");
        Assertions.assertThat(new ConvertionException(new IOException("exception"))).hasCause(IOException.class);
        Assertions.assertThat(new ConvertionException(new IOException("exception"))).hasCauseMessage("exception");
    }

}
