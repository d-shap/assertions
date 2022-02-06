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
package ru.d_shap.assertions.data;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ReflectionException}.
 *
 * @author Dmitry Shapovalov
 */
public final class ReflectionExceptionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ReflectionExceptionTest() {
        super();
    }

    /**
     * {@link ReflectionException} class test.
     */
    @Test
    public void reflectiveExceptionCauseTest() {
        Assertions.assertThat(new ReflectionException(null)).isNotNull();
        Assertions.assertThat(new ReflectionException(null)).isInstanceOf(ReflectionException.class);
        Assertions.assertThat(new ReflectionException(null)).toMessage().isNull();
        Assertions.assertThat(new ReflectionException(null)).toCause().isNull();

        Assertions.assertThat(new ReflectionException(new NoSuchFieldException())).isNotNull();
        Assertions.assertThat(new ReflectionException(new NoSuchFieldException())).isInstanceOf(ReflectionException.class);
        Assertions.assertThat(new ReflectionException(new NoSuchFieldException())).hasMessage("java.lang.NoSuchFieldException");
        Assertions.assertThat(new ReflectionException(new NoSuchFieldException())).hasCause(NoSuchFieldException.class);
        Assertions.assertThat(new ReflectionException(new NoSuchFieldException())).toCause().toMessage().isNull();

        Assertions.assertThat(new ReflectionException(new NoSuchFieldException("exception"))).isNotNull();
        Assertions.assertThat(new ReflectionException(new NoSuchFieldException("exception"))).isInstanceOf(ReflectionException.class);
        Assertions.assertThat(new ReflectionException(new NoSuchFieldException("exception"))).hasMessage("java.lang.NoSuchFieldException: exception");
        Assertions.assertThat(new ReflectionException(new NoSuchFieldException("exception"))).hasCause(NoSuchFieldException.class);
        Assertions.assertThat(new ReflectionException(new NoSuchFieldException("exception"))).hasCauseMessage("exception");
    }

}