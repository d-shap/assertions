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
package ru.d_shap.assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.converter.AsStringConverter;
import ru.d_shap.assertions.converter.AsStringConverterProvider;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ValueConverter;
import ru.d_shap.assertions.converter.ValueConverterProvider;
import ru.d_shap.assertions.data.ReflectionHelper;

/**
 * Tests for {@link AssertionErrorBuilder}.
 *
 * @author Dmitry Shapovalov
 */
public final class AssertionErrorBuilderTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public AssertionErrorBuilderTest() {
        super();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithMessageTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage("error message: {0}", true).build()).hasMessage("message.\n\terror message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("message.\n\terror message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).build()).hasMessage("message.\n\terror message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("message.\n\terror message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).build()).hasMessage("message.\n\terror message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("message.\n\terror message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithThrowableMessageTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage(new IOException("runtime exception")).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage(new IOException("runtime exception")).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("runtime exception")).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("value''s")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("value''s")).build()).hasMessage("message.\n\tjava.io.IOException: value''s.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new ConversionException(new IOException("value''s"))).build()).hasMessage("message.\n\tjava.io.IOException: value''s.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("value''s")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new ConversionException(new IOException("value''s"))).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().build()).hasMessage("Actual:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().build()).hasMessage("Actual:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().build()).hasMessage("message.\n\tActual:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addDelta("D!").build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addDelta(null).build()).hasMessage("Actual:<<NULL>±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addDelta("D!").build()).hasMessage("Actual:<<NULL>±D!>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addDelta(null).build()).hasMessage("Actual:<actual±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addDelta("D!").build()).hasMessage("Actual:<actual±D!>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addDelta(null).build()).hasMessage("message.\n\tActual:<actual±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addDelta("D!").build()).hasMessage("message.\n\tActual:<actual±D!>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addDelta("D!").build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).build()).hasMessage("message.\n\tExpected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithExpectedAndDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).addDelta(null).build()).hasMessage("Expected:<12345±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).addDelta("D!").build()).hasMessage("Expected:<12345±D!>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).addDelta(null).build()).hasMessage("Expected:<12345±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).addDelta("D!").build()).hasMessage("Expected:<12345±D!>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).addDelta(null).build()).hasMessage("message.\n\tExpected:<12345±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).addDelta("D!").build()).hasMessage("message.\n\tExpected:<12345±D!>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).addDelta("D!").build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithRawExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, Byte.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, Byte.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, Byte.class).build()).hasMessage("Expected:<123b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, Byte.class).build()).hasMessage("Expected:<123b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, Byte.class).build()).hasMessage("message.\n\tExpected:<123b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, Byte.class).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithRawExpectedAndDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("Expected:<123b±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("Expected:<123b±45b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("Expected:<123b±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("Expected:<123b±45b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("message.\n\tExpected:<123b±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("message.\n\tExpected:<123b±45b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).build()).hasMessage("Expected:<12345> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).build()).hasMessage("Expected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).build()).hasMessage("message.\n\tExpected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualExpectedAndDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).addDelta(null).build()).hasMessage("Expected:<12345±<NULL>> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).addDelta("D!").build()).hasMessage("Expected:<12345±D!> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).addDelta(null).build()).hasMessage("Expected:<12345±<NULL>> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).addDelta("D!").build()).hasMessage("Expected:<12345±D!> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).addDelta(null).build()).hasMessage("message.\n\tExpected:<12345±<NULL>> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).addDelta("D!").build()).hasMessage("message.\n\tExpected:<12345±D!> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).addDelta("D!").build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndRawExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, Byte.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, Byte.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, Byte.class).build()).hasMessage("Expected:<123b> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, Byte.class).build()).hasMessage("Expected:<123b> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, Byte.class).build()).hasMessage("message.\n\tExpected:<123b> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, Byte.class).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualRawExpectedAndDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("Expected:<123b±<NULL>> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("Expected:<123b±45b> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("Expected:<123b±<NULL>> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("Expected:<123b±45b> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(null).build()).hasMessage("message.\n\tExpected:<123b±<NULL>> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(45).build()).hasMessage("message.\n\tExpected:<123b±45b> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, Byte.class).addDelta(45).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).build()).hasMessage("message.\n\tExpected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithExpected2AndDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).addDelta(null).build()).hasMessage("Expected:<12345:67890±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).addDelta("D!").build()).hasMessage("Expected:<12345:67890±D!>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).addDelta(null).build()).hasMessage("Expected:<12345:67890±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).addDelta("D!").build()).hasMessage("Expected:<12345:67890±D!>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).addDelta(null).build()).hasMessage("message.\n\tExpected:<12345:67890±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).addDelta("D!").build()).hasMessage("message.\n\tExpected:<12345:67890±D!>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithRawExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, 67, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, 67, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, 67, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, 67, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, 67, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, 67, Byte.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, 67, Byte.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, 67, Byte.class).build()).hasMessage("Expected:<123b:67b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, 67, Byte.class).build()).hasMessage("Expected:<123b:67b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, 67, Byte.class).build()).hasMessage("message.\n\tExpected:<123b:67b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, 67, Byte.class).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithRawExpected2AndDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("Expected:<123b:67b±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("Expected:<123b:67b±45b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("Expected:<123b:67b±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("Expected:<123b:67b±45b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("message.\n\tExpected:<123b:67b±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("message.\n\tExpected:<123b:67b±45b>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).build()).hasMessage("message.\n\tExpected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualExpected2AndDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).addDelta(null).build()).hasMessage("Expected:<12345:67890±<NULL>> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("Expected:<12345:67890±D!> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).addDelta(null).build()).hasMessage("Expected:<12345:67890±<NULL>> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("Expected:<12345:67890±D!> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).addDelta(null).build()).hasMessage("message.\n\tExpected:<12345:67890±<NULL>> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).addDelta("D!").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).addDelta("D!").build()).hasMessage("message.\n\tExpected:<12345:67890±D!> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).addDelta("D!").build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndRawExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, 67, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, 67, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, 67, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, 67, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, 67, Byte.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, 67, Byte.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, 67, Byte.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, 67, Byte.class).build()).hasMessage("Expected:<123b:67b> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).build()).hasMessage("Expected:<123b:67b> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).build()).hasMessage("message.\n\tExpected:<123b:67b> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualRawExpected2AndDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("Expected:<123b:67b±<NULL>> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("Expected:<123b:67b±45b> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("Expected:<123b:67b±<NULL>> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("Expected:<123b:67b±45b> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).hasMessage("message.\n\tExpected:<123b:67b±<NULL>> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).hasMessage("message.\n\tExpected:<123b:67b±45b> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(123, 67, Byte.class).addDelta(45).build()).toCause().isNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithThrowableTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addThrowable(new IOException("runtime exception")).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addThrowable(new IOException("runtime exception")).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addThrowable(new IOException("runtime exception")).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addThrowable(new IOException("value''s")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addThrowable(new IOException("value''s")).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addThrowable(new ConversionException(new IOException("value''s"))).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addThrowable(new IOException("value''s")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addThrowable(new ConversionException(new IOException("value''s"))).build()).hasCause(IOException.class);
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void conversionExceptionTest() {
        List<ValueConverterProvider> valueConverterProviders = (List<ValueConverterProvider>) ReflectionHelper.getFieldValue(ValueConverter.class, null, "CONVERTER_PROVIDERS");
        valueConverterProviders.add(new ErrorTypeValueConverter());
        List<AsStringConverterProvider> asStringConverterProviders = (List<AsStringConverterProvider>) ReflectionHelper.getFieldValue(AsStringConverter.class, null, "CONVERTER_PROVIDERS");
        asStringConverterProviders.add(new ErrorTypeAsStringConverter());

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(new ErrorType()).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(new ErrorType()).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(new ErrorType()).build()).hasMessage("java.io.IOException: test conversion exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(new ErrorType()).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(new ErrorType()).build()).hasCauseMessage("test conversion exception");

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasMessage("java.io.IOException: test conversion exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCauseMessage("test conversion exception");

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasMessage("message.\n\tjava.io.IOException: test conversion exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCauseMessage("test conversion exception");

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(new FailDescription("message"), new FailDescriptionEntry("Error: {0}", new Object[]{"error!!!"}, false)), String.class, "actual").addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(new FailDescription("message"), new FailDescriptionEntry("Error: {0}", new Object[]{"error!!!"}, false)), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasMessage("message.\n\tError: error!!!\n\tjava.io.IOException: test conversion exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(new FailDescription("message"), new FailDescriptionEntry("Error: {0}", new Object[]{"error!!!"}, false)), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(new FailDescription("message"), new FailDescriptionEntry("Error: {0}", new Object[]{"error!!!"}, false)), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCauseMessage("test conversion exception");

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(new FailDescription("message"), new FailDescriptionEntry("Error: {0}", new Object[]{new ErrorType()}, false)), String.class, "actual").addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(new FailDescription("message"), new FailDescriptionEntry("Error: {0}", new Object[]{new ErrorType()}, false)), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasMessage("java.io.IOException: test conversion exception");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(new FailDescription("message"), new FailDescriptionEntry("Error: {0}", new Object[]{new ErrorType()}, false)), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(new FailDescription("message"), new FailDescriptionEntry("Error: {0}", new Object[]{new ErrorType()}, false)), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCauseMessage("test conversion exception");
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test(expected = NullPointerException.class)
    public void addRawExpectedNullFailTest() {
        throw AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected("expected", null).build();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test(expected = NullPointerException.class)
    public void addRawExpected2NullFailTest() {
        throw AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected("expected1", "expected2", null).build();
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ErrorType {

        ErrorType() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ErrorTypeValueConverter implements ValueConverterProvider {

        ErrorTypeValueConverter() {
            super();
        }

        @Override
        public Class<?> getValueClass() {
            return ErrorType.class;
        }

        @Override
        public Class<?> getTargetClass() {
            return String.class;
        }

        @Override
        public Object convert(final Object value, final Object... arguments) {
            throw new ConversionException(new IOException("test conversion exception"));
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ErrorTypeAsStringConverter implements AsStringConverterProvider {

        ErrorTypeAsStringConverter() {
            super();
        }

        @Override
        public Class<?> getValueClass() {
            return ErrorType.class;
        }

        @Override
        public String asString(final Object value) {
            throw new ConversionException(new IOException("test conversion exception"));
        }

    }

}
