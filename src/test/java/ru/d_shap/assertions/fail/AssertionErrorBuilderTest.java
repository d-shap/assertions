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
package ru.d_shap.assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.PrivateAccessor;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ValueConverter;
import ru.d_shap.assertions.converter.ValueConverterProvider;

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

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).build()).toCause().isNull();

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
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).build()).hasMessage("error message: true.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: true.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).build()).hasMessage("error message: true.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: true.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).build()).hasMessage("error message: true.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: true.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).build()).hasMessage("message.\n\terror message: true.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("message.\n\terror message: true.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).build()).hasMessage("error message: true.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: true.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).build()).hasMessage("error message: true.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("error message: true.\n\tmessage2.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addMessage("error message: {0}", true).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).build()).hasMessage("message.\n\terror message: true.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addMessage("error message: {0}", true).addMessage("message2").build()).hasMessage("message.\n\terror message: true.\n\tmessage2.");
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

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new IOException("runtime exception")).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("java.io.IOException: runtime exception.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new IOException("runtime exception")).build()).toCause().isNull();
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addMessage(new ConversionException(new IOException("runtime exception"))).build()).toCause().isNull();

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

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().build()).toCause().isNull();

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
    public void buildWithExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345).build()).toCause().isNull();

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
    public void buildWithActualAndExpectedTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345).build()).toCause().isNull();

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
    public void buildWithExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addExpected(12345, 67890).build()).toCause().isNull();

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
    public void buildWithActualAndExpected2Test() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(12345, 67890).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(12345, 67890).build()).toCause().isNull();

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
    public void buildWithThrowableTest() {
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addThrowable(new IOException("runtime exception")).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addThrowable(new IOException("runtime exception")).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addThrowable(new IOException("runtime exception")).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addThrowable(new ConversionException(new IOException("runtime exception"))).build()).hasCause(IOException.class);

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
     *
     * @throws Exception exception in test.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void conversionExceptionTest() throws Exception {
        List<ValueConverterProvider> converterProviders = (List<ValueConverterProvider>) PrivateAccessor.getFieldValue(ValueConverter.class, null, "CONVERTER_PROVIDERS");
        converterProviders.add(new ErrorTypeConverter());

        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance().addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, null, null).addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription(), null, null).addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(new ErrorType()).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), null, null).addActual().addExpected(new ErrorType()).build()).toCause().isNull();

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(new ErrorType()).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, null).addActual().addExpected(new ErrorType()).build()).hasCauseMessage("test conversion exception");

        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasMessage("");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(null, String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCauseMessage("test conversion exception");

        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(new ErrorType()).build()).isInstanceOf(AssertionError.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasMessage("message.");
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCause(IOException.class);
        Assertions.assertThat(AssertionErrorBuilder.getInstance(new FailDescription("message"), String.class, "actual").addActual().addExpected(new ErrorType()).build()).hasCauseMessage("test conversion exception");
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
    private static final class ErrorTypeConverter implements ValueConverterProvider {

        ErrorTypeConverter() {
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
        public Object convert(final Object value, final Object... arguments) throws ConversionException {
            throw new ConversionException(new IOException("test conversion exception"));
        }

    }

}
