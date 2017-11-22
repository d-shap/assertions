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

import org.junit.Test;

/**
 * Tests for {@link Raw}.
 *
 * @author Dmitry Shapovalov
 */
public final class RawTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public RawTest() {
        super();
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(Raw.class).hasOnePrivateConstructor();
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void byteAssertionTest() {
        initialize(Raw.byteAssertion(), null).isNull();
        try {
            Raw.byteAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void shortAssertionTest() {
        initialize(Raw.shortAssertion(), null).isNull();
        try {
            Raw.shortAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void intAssertionTest() {
        initialize(Raw.intAssertion(), null).isNull();
        try {
            Raw.intAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void longAssertionTest() {
        initialize(Raw.longAssertion(), null).isNull();
        try {
            Raw.longAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void floatAssertionTest() {
        initialize(Raw.floatAssertion(), null).isNull();
        try {
            Raw.floatAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void doubleAssertionTest() {
        initialize(Raw.doubleAssertion(), null).isNull();
        try {
            Raw.doubleAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void booleanAssertionTest() {
        initialize(Raw.booleanAssertion(), null).isNull();
        try {
            Raw.booleanAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void charAssertionTest() {
        initialize(Raw.charAssertion(), null).isNull();
        try {
            Raw.charAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void objectAssertionTest() {
        initialize(Raw.objectAssertion(), null).isNull();
        try {
            Raw.objectAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void byteArrayAssertionTest() {
        initialize(Raw.byteArrayAssertion(), null).isNull();
        try {
            Raw.byteArrayAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void shortArrayAssertionTest() {
        initialize(Raw.shortArrayAssertion(), null).isNull();
        try {
            Raw.shortArrayAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void intArrayAssertionTest() {
        initialize(Raw.intArrayAssertion(), null).isNull();
        try {
            Raw.intArrayAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void longArrayAssertionTest() {
        initialize(Raw.longArrayAssertion(), null).isNull();
        try {
            Raw.longArrayAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void floatArrayAssertionTest() {
        initialize(Raw.floatArrayAssertion(), null).isNull();
        try {
            Raw.floatArrayAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void doubleArrayAssertionTest() {
        initialize(Raw.doubleArrayAssertion(), null).isNull();
        try {
            Raw.doubleArrayAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void booleanArrayAssertionTest() {
        initialize(Raw.booleanArrayAssertion(), null).isNull();
        try {
            Raw.booleanArrayAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void charArrayAssertionTest() {
        initialize(Raw.charArrayAssertion(), null).isNull();
        try {
            Raw.charArrayAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void objectArrayAssertionTest() {
        initialize(Raw.objectArrayAssertion(), null).isNull();
        try {
            Raw.objectArrayAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void classAssertionTest() {
        initialize(Raw.classAssertion(), null).isNull();
        try {
            Raw.classAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void enumAssertionTest() {
        initialize(Raw.enumAssertion(), null).isNull();
        try {
            Raw.enumAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void charSequenceAssertionTest() {
        initialize(Raw.charSequenceAssertion(), null).isNull();
        try {
            Raw.charSequenceAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void stringAssertionTest() {
        initialize(Raw.stringAssertion(), null).isNull();
        try {
            Raw.stringAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void comparableAssertionTest() {
        initialize(Raw.comparableAssertion(), null).isNull();
        try {
            Raw.comparableAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void iterableAssertionTest() {
        initialize(Raw.iterableAssertion(), null).isNull();
        try {
            Raw.iterableAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void throwableAssertionTest() {
        initialize(Raw.throwableAssertion(), null).isNull();
        try {
            Raw.throwableAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void collectionAssertionTest() {
        initialize(Raw.collectionAssertion(), null).isNull();
        try {
            Raw.collectionAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void iteratorAssertionTest() {
        initialize(Raw.iteratorAssertion(), null).isNull();
        try {
            Raw.iteratorAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void listAssertionTest() {
        initialize(Raw.listAssertion(), null).isNull();
        try {
            Raw.listAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void setAssertionTest() {
        initialize(Raw.setAssertion(), null).isNull();
        try {
            Raw.setAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void mapAssertionTest() {
        initialize(Raw.mapAssertion(), null).isNull();
        try {
            Raw.mapAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void inputStreamAssertionTest() {
        initialize(Raw.inputStreamAssertion(), null).isNull();
        try {
            Raw.inputStreamAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void readerAssertionTest() {
        initialize(Raw.readerAssertion(), null).isNull();
        try {
            Raw.readerAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void byteBufferAssertionTest() {
        initialize(Raw.byteBufferAssertion(), null).isNull();
        try {
            Raw.byteBufferAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void shortBufferAssertionTest() {
        initialize(Raw.shortBufferAssertion(), null).isNull();
        try {
            Raw.shortBufferAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void intBufferAssertionTest() {
        initialize(Raw.intBufferAssertion(), null).isNull();
        try {
            Raw.intBufferAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void longBufferAssertionTest() {
        initialize(Raw.longBufferAssertion(), null).isNull();
        try {
            Raw.longBufferAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void floatBufferAssertionTest() {
        initialize(Raw.floatBufferAssertion(), null).isNull();
        try {
            Raw.floatBufferAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void doubleBufferAssertionTest() {
        initialize(Raw.doubleBufferAssertion(), null).isNull();
        try {
            Raw.doubleBufferAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

    /**
     * {@link Raw} class test.
     */
    @Test
    public void charBufferAssertionTest() {
        initialize(Raw.charBufferAssertion(), null).isNull();
        try {
            Raw.charBufferAssertion().isNull();
            Assertions.fail("Raw test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
    }

}
