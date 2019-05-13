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
 * Tests for {@link ConversionExceptionHolder}.
 *
 * @author Dmitry Shapovalov
 */
public final class ConversionExceptionHolderTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ConversionExceptionHolderTest() {
        super();
    }

    /**
     * {@link ConversionExceptionHolder} class test.
     */
    @Test
    public void hasConversionExceptionTest() {
        ConversionExceptionHolder conversionExceptionHolder1 = new ConversionExceptionHolder();
        Assertions.assertThat(conversionExceptionHolder1.hasConversionException()).isFalse();

        ConversionExceptionHolder conversionExceptionHolder2 = new ConversionExceptionHolder();
        conversionExceptionHolder2.setConversionException(null);
        Assertions.assertThat(conversionExceptionHolder2.hasConversionException()).isFalse();

        ConversionExceptionHolder conversionExceptionHolder3 = new ConversionExceptionHolder();
        ConversionException conversionException3 = new ConversionException(new IOException());
        conversionExceptionHolder3.setConversionException(conversionException3);
        Assertions.assertThat(conversionExceptionHolder3.hasConversionException()).isTrue();
    }

    /**
     * {@link ConversionExceptionHolder} class test.
     */
    @Test
    public void getConversionExceptionTest() {
        ConversionExceptionHolder conversionExceptionHolder1 = new ConversionExceptionHolder();
        Assertions.assertThat(conversionExceptionHolder1.getConversionException()).isNull();
        Assertions.assertThat(conversionExceptionHolder1.getConversionException()).isNull();

        ConversionExceptionHolder conversionExceptionHolder2 = new ConversionExceptionHolder();
        conversionExceptionHolder2.setConversionException(null);
        Assertions.assertThat(conversionExceptionHolder2.getConversionException()).isNull();
        Assertions.assertThat(conversionExceptionHolder2.getConversionException()).isNull();

        ConversionExceptionHolder conversionExceptionHolder3 = new ConversionExceptionHolder();
        ConversionException conversionException3 = new ConversionException(new IOException());
        conversionExceptionHolder3.setConversionException(conversionException3);
        Assertions.assertThat(conversionExceptionHolder3.getConversionException()).isSameAs(conversionException3);
        Assertions.assertThat(conversionExceptionHolder3.getConversionException()).isSameAs(conversionException3);
    }

    /**
     * {@link ConversionExceptionHolder} class test.
     */
    @Test
    public void setConversionExceptionTest() {
        ConversionExceptionHolder conversionExceptionHolder1 = new ConversionExceptionHolder();
        ConversionException conversionException1 = new ConversionException(new IOException());
        conversionExceptionHolder1.setConversionException(conversionException1);
        conversionExceptionHolder1.setConversionException(conversionException1);
        Assertions.assertThat(conversionExceptionHolder1.getConversionException()).isSameAs(conversionException1);

        ConversionExceptionHolder conversionExceptionHolder2 = new ConversionExceptionHolder();
        ConversionException conversionException2 = new ConversionException(new IOException());
        conversionExceptionHolder2.setConversionException(conversionException2);
        conversionExceptionHolder2.setConversionException(null);
        Assertions.assertThat(conversionExceptionHolder2.getConversionException()).isNull();

        ConversionExceptionHolder conversionExceptionHolder3 = new ConversionExceptionHolder();
        ConversionException conversionException3 = new ConversionException(new IOException());
        conversionExceptionHolder3.setConversionException(null);
        conversionExceptionHolder3.setConversionException(conversionException3);
        Assertions.assertThat(conversionExceptionHolder3.getConversionException()).isSameAs(conversionException3);

        ConversionExceptionHolder conversionExceptionHolder4 = new ConversionExceptionHolder();
        conversionExceptionHolder4.setConversionException(null);
        conversionExceptionHolder4.setConversionException(null);
        Assertions.assertThat(conversionExceptionHolder4.getConversionException()).isNull();
    }

}
