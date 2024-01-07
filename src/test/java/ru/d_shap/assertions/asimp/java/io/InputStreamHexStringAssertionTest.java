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
package ru.d_shap.assertions.asimp.java.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link InputStreamAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class InputStreamHexStringAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public InputStreamHexStringAssertionTest() {
        super();
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString().isEqualTo("010203");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString().isEqualTo("63f1170788");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).isNotNull().toHexString().isEqualTo("63f1170788");

        try {
            Raw.inputStreamAssertion().toHexString();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toHexString();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toHexString();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).toHexString();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").toHexString();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString()).isEqualTo("010203");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toHexString()).isEqualTo("010203");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString().isEqualTo("aaff");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<aaff> but was:<010203>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toHexString().isEqualTo("aaff");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<aaff> but was:<010203>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toHexStringCountTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(4).isEqualTo("010203");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(3).isEqualTo("010203");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(2).isEqualTo("0102");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(1).isEqualTo("01");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(5).isEqualTo("63f1170788");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(4).isEqualTo("63f11707");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(3).isEqualTo("63f117");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(2).isEqualTo("63f1");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(1).isEqualTo("63");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).isNotNull().toHexString(1).isEqualTo("63");

        try {
            Raw.inputStreamAssertion().toHexString(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toHexString(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toHexString(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toHexString(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toHexString(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toHexString(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toHexString(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toHexString(-1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toHexString(-1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).toHexString(3);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").toHexString(3);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(1)).isEqualTo("01");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 1.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toHexString(1)).isEqualTo("01");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 1.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(4).isEqualTo("aaff");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<aaff> but was:<010203>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toHexString(4).isEqualTo("aaff");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 4.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<aaff> but was:<010203>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(Matchers.is(Matchers.equalTo("010203")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(Matchers.is(Matchers.equalTo("63f1170788")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).isNotNull().toHexString(Matchers.is(Matchers.equalTo("63f1170788"))).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().toHexString(Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toHexString(Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toHexString(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toHexString(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toHexString(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toHexString(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).toHexString(Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(Matchers.equalTo("aaff"));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tCheck actual value's hex representation.\nExpected: \"aaff\"\n     but: was \"010203\"");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toHexString(Matchers.equalTo("aaff"));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tCheck actual value's hex representation.\nExpected: \"aaff\"\n     but: was \"010203\"");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toHexStringCountMatcherTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(4, Matchers.is(Matchers.equalTo("010203")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(3, Matchers.is(Matchers.equalTo("010203")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(2, Matchers.is(Matchers.equalTo("0102")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(1, Matchers.is(Matchers.equalTo("01")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(5, Matchers.is(Matchers.equalTo("63f1170788")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(4, Matchers.is(Matchers.equalTo("63f11707")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(3, Matchers.is(Matchers.equalTo("63f117")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(2, Matchers.is(Matchers.equalTo("63f1")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).toHexString(1, Matchers.is(Matchers.equalTo("63")));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).isNotNull().toHexString(1, Matchers.is(Matchers.equalTo("63"))).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().toHexString(1, Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toHexString(1, Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toHexString(1, Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toHexString(0, Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toHexString(0, Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toHexString(0, Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toHexString(0, Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toHexString(0, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toHexString(0, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toHexString(3, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toHexString(3, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).toHexString(3, Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").toHexString(3, Matchers.equalTo(""));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toHexString(4, Matchers.equalTo("aaff"));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tCheck actual value's hex representation.\nExpected: \"aaff\"\n     but: was \"010203\"");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toHexString(4, Matchers.equalTo("aaff"));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 4.\n\tCheck actual value's hex representation.\nExpected: \"aaff\"\n     but: was \"010203\"");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).hasHexString("010203");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).hasHexString("63f1170788");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).isNotNull().hasHexString("63f1170788").isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().hasHexString("");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).hasHexString("");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").hasHexString("");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).hasHexString(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").hasHexString(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).hasHexString(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").hasHexString(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).hasHexString("");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").hasHexString("");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).hasHexString("aaff");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<aaff> but was:<010203>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").hasHexString("aaff");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<aaff> but was:<010203>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void hasHexStringCountTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).hasHexString(4, "010203");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).hasHexString(3, "010203");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).hasHexString(2, "0102");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).hasHexString(1, "01");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).hasHexString(5, "63f1170788");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).hasHexString(4, "63f11707");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).hasHexString(3, "63f117");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).hasHexString(2, "63f1");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).hasHexString(1, "63");
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{99, -15, 23, 7, -120})).isNotNull().hasHexString(1, "63").isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().hasHexString(1, "");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).hasHexString(1, "");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").hasHexString(1, "");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).hasHexString(0, "");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").hasHexString(0, "");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).hasHexString(0, "");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").hasHexString(0, "");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).hasHexString(0, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").hasHexString(0, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).hasHexString(3, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").hasHexString(3, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).hasHexString(3, "");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").hasHexString(3, "");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).hasHexString(4, "aaff");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<aaff> but was:<010203>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").hasHexString(4, "aaff");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 4.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<aaff> but was:<010203>");
        }
    }

}
