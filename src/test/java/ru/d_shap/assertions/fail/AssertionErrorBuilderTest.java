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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.converter.ConversionException;

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

}
