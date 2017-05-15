///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
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

import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ru.d_shap.assertions.array.BooleanArrayAssertion;
import ru.d_shap.assertions.array.ByteArrayAssertion;
import ru.d_shap.assertions.array.CharArrayAssertion;
import ru.d_shap.assertions.array.DoubleArrayAssertion;
import ru.d_shap.assertions.array.FloatArrayAssertion;
import ru.d_shap.assertions.array.IntArrayAssertion;
import ru.d_shap.assertions.array.LongArrayAssertion;
import ru.d_shap.assertions.array.ObjectArrayAssertion;
import ru.d_shap.assertions.array.ShortArrayAssertion;
import ru.d_shap.assertions.collection.CollectionAssertion;
import ru.d_shap.assertions.collection.IteratorAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.collection.MapAssertion;
import ru.d_shap.assertions.collection.SetAssertion;
import ru.d_shap.assertions.core.CharSequenceAssertion;
import ru.d_shap.assertions.core.ClassAssertion;
import ru.d_shap.assertions.core.ComparableAssertion;
import ru.d_shap.assertions.core.IterableAssertion;
import ru.d_shap.assertions.core.ObjectAssertion;
import ru.d_shap.assertions.core.StringAssertion;
import ru.d_shap.assertions.core.ThrowableAssertion;
import ru.d_shap.assertions.io.InputStreamAssertion;
import ru.d_shap.assertions.io.ReaderAssertion;
import ru.d_shap.assertions.primitive.BooleanAssertion;
import ru.d_shap.assertions.primitive.ByteAssertion;
import ru.d_shap.assertions.primitive.CharAssertion;
import ru.d_shap.assertions.primitive.DoubleAssertion;
import ru.d_shap.assertions.primitive.FloatAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.primitive.LongAssertion;
import ru.d_shap.assertions.primitive.ShortAssertion;

/**
 * Entry point of all assertions.
 *
 * @author Dmitry Shapovalov
 */
public final class Assertions {

    private Assertions() {
        super();
    }

    /**
     * Make assertion with the assertion message.
     *
     * @param message the assertion message.
     * @return the assertion.
     */
    public static MessageAssertion assertWithMessage(final String message) {
        return new MessageAssertion(message);
    }

    /**
     * Make assertion about the byte.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ByteAssertion assertThat(final byte actual) {
        return new ByteAssertion(actual, null);
    }

    /**
     * Make assertion about the short.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ShortAssertion assertThat(final short actual) {
        return new ShortAssertion(actual, null);
    }

    /**
     * Make assertion about the int.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static IntAssertion assertThat(final int actual) {
        return new IntAssertion(actual, null);
    }

    /**
     * Make assertion about the long.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static LongAssertion assertThat(final long actual) {
        return new LongAssertion(actual, null);
    }

    /**
     * Make assertion about the float.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static FloatAssertion assertThat(final float actual) {
        return new FloatAssertion(actual, null);
    }

    /**
     * Make assertion about the double.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static DoubleAssertion assertThat(final double actual) {
        return new DoubleAssertion(actual, null);
    }

    /**
     * Make assertion about the boolean.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static BooleanAssertion assertThat(final boolean actual) {
        return new BooleanAssertion(actual, null);
    }

    /**
     * Make assertion about the char.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static CharAssertion assertThat(final char actual) {
        return new CharAssertion(actual, null);
    }

    /**
     * Make assertion about the object.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ObjectAssertion assertThat(final Object actual) {
        return new ObjectAssertion(actual, null);
    }

    /**
     * Make assertion about the byte array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ByteArrayAssertion assertThat(final byte[] actual) {
        return new ByteArrayAssertion(actual, null);
    }

    /**
     * Make assertion about the short array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ShortArrayAssertion assertThat(final short[] actual) {
        return new ShortArrayAssertion(actual, null);
    }

    /**
     * Make assertion about the int array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static IntArrayAssertion assertThat(final int[] actual) {
        return new IntArrayAssertion(actual, null);
    }

    /**
     * Make assertion about the long array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static LongArrayAssertion assertThat(final long[] actual) {
        return new LongArrayAssertion(actual, null);
    }

    /**
     * Make assertion about the float array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static FloatArrayAssertion assertThat(final float[] actual) {
        return new FloatArrayAssertion(actual, null);
    }

    /**
     * Make assertion about the double array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static DoubleArrayAssertion assertThat(final double[] actual) {
        return new DoubleArrayAssertion(actual, null);
    }

    /**
     * Make assertion about the boolean array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static BooleanArrayAssertion assertThat(final boolean[] actual) {
        return new BooleanArrayAssertion(actual, null);
    }

    /**
     * Make assertion about the char array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static CharArrayAssertion assertThat(final char[] actual) {
        return new CharArrayAssertion(actual, null);
    }

    /**
     * Make assertion about the object array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ObjectArrayAssertion assertThat(final Object[] actual) {
        return new ObjectArrayAssertion(actual, null);
    }

    /**
     * Make assertion about the class.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ClassAssertion assertThat(final Class<?> actual) {
        return new ClassAssertion(actual, null);
    }

    /**
     * Make assertion about the char sequence.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static CharSequenceAssertion assertThat(final CharSequence actual) {
        return new CharSequenceAssertion(actual, null);
    }

    /**
     * Make assertion about the string.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static StringAssertion assertThat(final String actual) {
        return new StringAssertion(actual, null);
    }

    /**
     * Make assertion about the comparable.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ComparableAssertion assertThat(final Comparable<?> actual) {
        return new ComparableAssertion(actual, null);
    }

    /**
     * Make assertion about the iterable.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static IterableAssertion assertThat(final Iterable<?> actual) {
        return new IterableAssertion(actual, null);
    }

    /**
     * Make assertion about the throwable.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ThrowableAssertion assertThat(final Throwable actual) {
        return new ThrowableAssertion(actual, null);
    }

    /**
     * Make assertion about the collection.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static CollectionAssertion assertThat(final Collection<?> actual) {
        return new CollectionAssertion(actual, null);
    }

    /**
     * Make assertion about the iterator.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static IteratorAssertion assertThat(final Iterator<?> actual) {
        return new IteratorAssertion(actual, null);
    }

    /**
     * Make assertion about the list.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ListAssertion assertThat(final List<?> actual) {
        return new ListAssertion(actual, null);
    }

    /**
     * Make assertion about the set.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static SetAssertion assertThat(final Set<?> actual) {
        return new SetAssertion(actual, null);
    }

    /**
     * Make assertion about the map.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static MapAssertion assertThat(final Map<?, ?> actual) {
        return new MapAssertion(actual, null);
    }

    /**
     * Make assertion about the input stream.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static InputStreamAssertion assertThat(final InputStream actual) {
        return new InputStreamAssertion(actual, null);
    }

    /**
     * Make assertion about the reader.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public static ReaderAssertion assertThat(final Reader actual) {
        return new ReaderAssertion(actual, null);
    }

    /**
     * Fail a test.
     *
     * @param failMessage the fail message.
     */
    public static void fail(final String failMessage) {
        throw BaseAssertion.createAssertionError(null, failMessage);
    }

}
