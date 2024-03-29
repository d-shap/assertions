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
package ru.d_shap.assertions;

import java.io.IOException;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import ru.d_shap.assertions.converter.AsStringConverter;
import ru.d_shap.assertions.converter.AsStringConverterProvider;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.fail.FailDescription;
import ru.d_shap.assertions.util.ReflectionHelper;

/**
 * Tests for {@link HamcrestMatcher}.
 *
 * @author Dmitry Shapovalov
 */
public final class HamcrestMatcherTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public HamcrestMatcherTest() {
        super();
    }

    /**
     * {@link HamcrestMatcherTest} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(HamcrestMatcher.class).hasOnePrivateConstructor();
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    public void matcherAssertionTest() {
        HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(10));

        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11));
            Assertions.fail(HamcrestMatcher.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("\nExpected: <11>\n     but: was <10>");
        }
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    public void matcherAssertionWithMessageTest() {
        HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(10), "message: {0}", 1);

        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), "message: {0}", 1);
            Assertions.fail(HamcrestMatcher.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("message: 1.\nExpected: <11>\n     but: was <10>");
        }
        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), "value''s");
            Assertions.fail(HamcrestMatcher.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("value's.\nExpected: <11>\n     but: was <10>");
        }
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    public void matcherAssertionWithFailDescriptionTest() {
        HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(10), new FailDescription("message"));

        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), new FailDescription("message"));
            Assertions.fail(HamcrestMatcher.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("message.\nExpected: <11>\n     but: was <10>");
        }
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    public void matcherAssertionWithFailDescriptionAndMesageTest() {
        HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(10), new FailDescription("message1"), "message2: {0}", 1);

        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), new FailDescription("message1"), "message2: {0}", 1);
            Assertions.fail(HamcrestMatcher.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("message1.\n\tmessage2: 1.\nExpected: <11>\n     but: was <10>");
        }
        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), new FailDescription("message1"), "value''s");
            Assertions.fail(HamcrestMatcher.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("message1.\n\tvalue's.\nExpected: <11>\n     but: was <10>");
        }
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    public void genericsTest() {
        HamcrestMatcher.matcherAssertion(new ClassA(), new MatcherA());
        HamcrestMatcher.matcherAssertion(new ClassB(), new MatcherA());
        HamcrestMatcher.matcherAssertion(new ClassC(), new MatcherA());

        HamcrestMatcher.matcherAssertion(new ClassB(), new MatcherB());
        HamcrestMatcher.matcherAssertion(new ClassC(), new MatcherB());

        HamcrestMatcher.matcherAssertion(new ClassC(), new MatcherC());
    }

    /**
     * {@link HamcrestMatcher} class test.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void conversionExceptionTest() {
        List<AsStringConverterProvider> asStringConverterProviders = (List<AsStringConverterProvider>) ReflectionHelper.getFieldValue(AsStringConverter.class, null, "CONVERTER_PROVIDERS");
        asStringConverterProviders.add(new ErrorTypeAsStringConverter());

        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), "message: {0}", new ErrorType());
            Assertions.fail(HamcrestMatcher.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: test conversion exception.");
        }
        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), new FailDescription("message: {0}", new ErrorType()));
            Assertions.fail(HamcrestMatcher.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: test conversion exception");
        }
        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), new FailDescription("message1"), "message: {0}", new ErrorType());
            Assertions.fail(HamcrestMatcher.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("message1.\n\tjava.io.IOException: test conversion exception.");
        }
        try {
            HamcrestMatcher.matcherAssertion(10, Matchers.equalTo(11), new FailDescription("message: {0}", new ErrorType()), "message: {0}", new ErrorType());
            Assertions.fail(HamcrestMatcher.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: test conversion exception");
        }
    }

    private static class ClassA {

        ClassA() {
            super();
        }

    }

    private static class ClassB extends ClassA {

        ClassB() {
            super();
        }

    }

    private static class ClassC extends ClassB {

        ClassC() {
            super();
        }

    }

    private static final class MatcherA extends TypeSafeMatcher<ClassA> {

        MatcherA() {
            super();
        }

        @Override
        protected boolean matchesSafely(final ClassA classA) {
            return true;
        }

        @Override
        public void describeTo(final Description description) {

        }

    }

    private static final class MatcherB extends TypeSafeMatcher<ClassB> {

        MatcherB() {
            super();
        }

        @Override
        protected boolean matchesSafely(final ClassB classB) {
            return true;
        }

        @Override
        public void describeTo(final Description description) {

        }

    }

    private static final class MatcherC extends TypeSafeMatcher<ClassC> {

        MatcherC() {
            super();
        }

        @Override
        protected boolean matchesSafely(final ClassC classB) {
            return true;
        }

        @Override
        public void describeTo(final Description description) {

        }

    }

    private static final class ErrorType {

        ErrorType() {
            super();
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
