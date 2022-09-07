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
import ru.d_shap.assertions.util.ReflectionHelper;

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
        Assertions.assertThat(AssertionErrorBuilder.getInstance().build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithMessageTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage("error message: {0}", true).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage("error message: {0}", true).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage("error message: {0}", true).build()).hasMessage("message.\n\terror message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("message.\n\terror message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage("error message: {0}", true).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).build()).hasMessage("message.\n\terror message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("message.\n\terror message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).build()).hasMessage("error message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).build()).hasMessage("message.\n\terror message: T.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("message.\n\terror message: T.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithThrowableMessageTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage(new IOException("runtime exception")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage(new ConversionException(new IOException("runtime exception"))).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage(new IOException("runtime exception")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new IOException("runtime exception")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage(new IOException("runtime exception")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addMessage(new ConversionException(new IOException("runtime exception"))).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new IOException("runtime exception")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage(new IOException("runtime exception")).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage(new IOException("runtime exception")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addMessage(new ConversionException(new IOException("runtime exception"))).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage(new IOException("runtime exception")).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage(new IOException("runtime exception")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage(new IOException("runtime exception")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage(new IOException("runtime exception")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage(new ConversionException(new IOException("runtime exception"))).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("runtime exception")).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("message.\n\tjava.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("runtime exception")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new ConversionException(new IOException("runtime exception"))).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("value''s")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("value''s")).build()).hasMessage("message.\n\tjava.io.IOException: value''s.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new ConversionException(new IOException("value''s"))).build()).hasMessage("message.\n\tjava.io.IOException: value''s.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new IOException("value''s")).build()).causeIsNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage(new ConversionException(new IOException("value''s"))).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().build()).hasMessage("Actual:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().build()).hasMessage("Actual:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().build()).hasMessage("message.\n\tActual:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta(null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta(null).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta(null).build()).hasMessage("Actual:<<NULL>±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").build()).hasMessage("Actual:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(null).build()).hasMessage("Actual:<actual±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").build()).hasMessage("Actual:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta(null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta(null).build()).hasMessage("message.\n\tActual:<actual±<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta(null).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").build()).hasMessage("message.\n\tActual:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta(true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta(true).build()).hasMessage("message.\n\tActual:<actual±T>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta(true).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), Integer.class, 123).addActualWithDelta(true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), Integer.class, 123).addActualWithDelta(true).build()).hasMessage("message.\n\tActual:<123±T>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), Integer.class, 123).addActualWithDelta(true).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected(12345).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected("12345").build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected("12345").build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpected(12345).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).build()).hasMessage("message.\n\tExpected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).build()).hasMessage("message.\n\tExpected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpected(12345, 67890).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithExpectedDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpectedWithDelta(12345, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpectedWithDelta(12345, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpectedWithDelta(12345, 15).build()).hasMessage("message.\n\tExpected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpectedWithDelta(12345, 15).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithExpected2DeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("message.\n\tExpected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected(12345).build()).hasMessage("Expected:<12345> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).build()).hasMessage("Expected:<12345> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected("12345").build()).hasMessage("Expected:<12345> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected("12345").build()).hasMessage("Expected:<12345> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected("12345").build()).hasMessage("Expected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).build()).hasMessage("Expected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected("12345").build()).hasMessage("Expected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected(12345).build()).hasMessage("Expected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).build()).hasMessage("message.\n\tExpected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).build()).hasMessage("message.\n\tExpected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(12345, 67890).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndExpectedDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpectedWithDelta(12345, 15).build()).hasMessage("message.\n\tExpected:<12345±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpectedWithDelta(12345, 15).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndExpected2DeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("message.\n\tExpected:<12345:67890±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualDeltaAndExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpected(12345).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpected(12345).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected(12345).build()).hasMessage("Expected:<12345> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected(12345).build()).hasMessage("Expected:<12345> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected("12345").build()).hasMessage("Expected:<12345> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected("12345").build()).hasMessage("Expected:<12345> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected("12345").build()).hasMessage("Expected:<12345> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected(12345).build()).hasMessage("Expected:<12345> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected("12345").build()).hasMessage("Expected:<12345> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected(12345).build()).hasMessage("Expected:<12345> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected("12345").build()).hasMessage("Expected:<12345> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected(12345).build()).hasMessage("Expected:<12345> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected("12345").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected("12345").build()).hasMessage("Expected:<12345> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected("12345").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected(12345).build()).hasMessage("Expected:<12345> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected(12345).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpected(12345).build()).hasMessage("message.\n\tExpected:<12345> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpected(12345).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualDeltaAndExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected("12345", "67890").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected("12345", "67890").build()).hasMessage("Expected:<12345:67890> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected("12345", "67890").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected(12345, 67890).build()).hasMessage("Expected:<12345:67890> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpected(12345, 67890).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpected(12345, 67890).build()).hasMessage("message.\n\tExpected:<12345:67890> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpected(12345, 67890).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualDeltaAndExpectedDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "15").build()).hasMessage("Expected:<12345±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 15).build()).hasMessage("Expected:<12345±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).hasMessage("message.\n\tExpected:<12345±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 15).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualDeltaAndExpected2DeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "67890", "15").build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "67890", "15").build()).hasMessage("Expected:<12345:67890±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta("12345", "67890", "15").build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).hasMessage("message.\n\tExpected:<12345:67890±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addExpectedWithDelta(12345, 67890, 15).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithRawExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(12345, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(12345, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(true, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(true, Boolean.class).build()).hasMessage("Expected:<T>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(true, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(12345, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(12345, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithRawExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(true, false, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(true, false, Boolean.class).build()).hasMessage("Expected:<T:F>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpected(true, false, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345:67890>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithRawExpectedDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(true, false, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(true, false, Boolean.class).build()).hasMessage("Expected:<T±F>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(true, false, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithRawExpected2DeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(true, false, true, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(true, false, true, Boolean.class).build()).hasMessage("Expected:<T:F±T>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addRawExpectedWithDelta(true, false, true, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345:67890±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndRawExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(true, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(true, Boolean.class).build()).hasMessage("Expected:<T> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(true, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(12345, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(12345, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndRawExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(true, false, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(true, false, Boolean.class).build()).hasMessage("Expected:<T:F> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpected(true, false, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345:67890> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndRawExpectedDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(true, false, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(true, false, Boolean.class).build()).hasMessage("Expected:<T±F> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(true, false, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndRawExpected2DeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(true, false, true, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(true, false, true, Boolean.class).build()).hasMessage("Expected:<T:F±T> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActual().addRawExpectedWithDelta(true, false, true, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345:67890±15> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualDeltaAndRawExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected("12345", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected("12345", Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected("12345", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(12345, Boolean.class).build()).hasMessage("Expected:<12345> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(12345, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(true, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(true, Boolean.class).build()).hasMessage("Expected:<T> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(true, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualDeltaAndRawExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected("12345", "67890", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected("12345", "67890", Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected("12345", "67890", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("Expected:<12345:67890> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(true, false, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(true, false, Boolean.class).build()).hasMessage("Expected:<T:F> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpected(true, false, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345:67890> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpected(12345, 67890, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualDeltaAndRawExpectedDeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("Expected:<12345±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(true, false, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(true, false, Boolean.class).build()).hasMessage("Expected:<T±F> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(true, false, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 15, Boolean.class).build()).causeIsNull();
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualDeltaAndRawExpected2DeltaTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<<NULL>±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta("12345", "67890", "15", Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("Expected:<12345:67890±15> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(true, false, true, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(true, false, true, Boolean.class).build()).hasMessage("Expected:<T:F±T> but was:<actual±15>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, Integer.class, "actual").addActualWithDelta(15).addRawExpectedWithDelta(true, false, true, Boolean.class).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).hasMessage("message.\n\tExpected:<12345:67890±15> but was:<actual±delta>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActualWithDelta("delta").addRawExpectedWithDelta(12345, 67890, 15, Boolean.class).build()).causeIsNull();
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
    public void buildWithActualAndThrowableTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addThrowable(new IOException("runtime exception")).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addThrowable(new IOException("runtime exception")).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addThrowable(new IOException("runtime exception")).build()).hasMessage("Actual:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addThrowable(new IOException("runtime exception")).build()).hasMessage("Actual:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addThrowable(new IOException("runtime exception")).build()).hasMessage("message.\n\tActual:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndExpectedAndThrowableTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasMessage("Expected:<5> but was:<<NULL>>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasMessage("Expected:<5> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasMessage("message.\n\tExpected:<5> but was:<actual>");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(5).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithSuppressedThrowableTest() {
        // TODO
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithSuppressedThrowablesTest() {
        // TODO
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndSuppressedThrowableTest() {
        // TODO
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndSuppressedThrowablesTest() {
        // TODO
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndExpectedAndSuppressedThrowableTest() {
        // TODO
    }

    /**
     * {@link AssertionErrorBuilder} class test.
     */
    @Test
    public void buildWithActualAndExpectedAndSuppressedThrowablesTest() {
        // TODO
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
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(new ErrorType()).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null).addActual().addExpected(new ErrorType()).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(new ErrorType()).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription()).addActual().addExpected(new ErrorType()).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(new ErrorType()).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(new ErrorType()).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message")).addActual().addExpected(new ErrorType()).build()).causeIsNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(new ErrorType()).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(new ErrorType()).build()).causeIsNull();

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

    private static final class ErrorType {

        ErrorType() {
            super();
        }

    }

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
