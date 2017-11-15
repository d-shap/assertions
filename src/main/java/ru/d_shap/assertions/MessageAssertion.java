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

import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
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
import ru.d_shap.assertions.nio.ByteBufferAssertion;
import ru.d_shap.assertions.nio.CharBufferAssertion;
import ru.d_shap.assertions.nio.DoubleBufferAssertion;
import ru.d_shap.assertions.nio.FloatBufferAssertion;
import ru.d_shap.assertions.nio.IntBufferAssertion;
import ru.d_shap.assertions.nio.LongBufferAssertion;
import ru.d_shap.assertions.nio.ShortBufferAssertion;
import ru.d_shap.assertions.primitive.BooleanAssertion;
import ru.d_shap.assertions.primitive.ByteAssertion;
import ru.d_shap.assertions.primitive.CharAssertion;
import ru.d_shap.assertions.primitive.DoubleAssertion;
import ru.d_shap.assertions.primitive.FloatAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.primitive.LongAssertion;
import ru.d_shap.assertions.primitive.ShortAssertion;

/**
 * Entry point of all assertions with the assertion message.
 *
 * @author Dmitry Shapovalov
 */
public final class MessageAssertion {

    private final String _message;

    MessageAssertion(final String message) {
        super();
        _message = message;
    }

    /**
     * Make assertion about the byte.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ByteAssertion that(final byte actual) {
        ByteAssertion assertion = Raw.byteAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the short.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ShortAssertion that(final short actual) {
        ShortAssertion assertion = Raw.shortAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the int.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public IntAssertion that(final int actual) {
        IntAssertion assertion = Raw.intAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the long.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public LongAssertion that(final long actual) {
        LongAssertion assertion = Raw.longAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the float.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public FloatAssertion that(final float actual) {
        FloatAssertion assertion = Raw.floatAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the double.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public DoubleAssertion that(final double actual) {
        DoubleAssertion assertion = Raw.doubleAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the boolean.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public BooleanAssertion that(final boolean actual) {
        BooleanAssertion assertion = Raw.booleanAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the char.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public CharAssertion that(final char actual) {
        CharAssertion assertion = Raw.charAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the object.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ObjectAssertion that(final Object actual) {
        ObjectAssertion assertion = Raw.objectAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion of specified type about the object.
     *
     * @param actual    the actual value.
     * @param assertion the assertion.
     * @param <T>       generic assertion type.
     * @return the assertion.
     */
    public <T extends BaseAssertion> T that(final Object actual, final T assertion) {
        return that(actual).as(assertion);
    }

    /**
     * Make assertion about the object's field.
     *
     * @param actual    the actual value.
     * @param fieldName the field name.
     * @return the assertion.
     */
    public ObjectAssertion that(final Object actual, final String fieldName) {
        return that(actual).toField(fieldName);
    }

    /**
     * Make assertion of specified type about the object's field.
     *
     * @param actual    the actual value.
     * @param fieldName the field name.
     * @param assertion the assertion.
     * @param <T>       generic assertion type.
     * @return the assertion.
     */
    public <T extends BaseAssertion> T that(final Object actual, final String fieldName, final T assertion) {
        return that(actual).toField(fieldName, assertion);
    }

    /**
     * Make assertion about the byte array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ByteArrayAssertion that(final byte[] actual) {
        ByteArrayAssertion assertion = Raw.byteArrayAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the short array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ShortArrayAssertion that(final short[] actual) {
        ShortArrayAssertion assertion = Raw.shortArrayAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the int array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public IntArrayAssertion that(final int[] actual) {
        IntArrayAssertion assertion = Raw.intArrayAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the long array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public LongArrayAssertion that(final long[] actual) {
        LongArrayAssertion assertion = Raw.longArrayAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the float array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public FloatArrayAssertion that(final float[] actual) {
        FloatArrayAssertion assertion = Raw.floatArrayAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the double array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public DoubleArrayAssertion that(final double[] actual) {
        DoubleArrayAssertion assertion = Raw.doubleArrayAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the boolean array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public BooleanArrayAssertion that(final boolean[] actual) {
        BooleanArrayAssertion assertion = Raw.booleanArrayAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the char array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public CharArrayAssertion that(final char[] actual) {
        CharArrayAssertion assertion = Raw.charArrayAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the object array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ObjectArrayAssertion that(final Object[] actual) {
        ObjectArrayAssertion assertion = Raw.objectArrayAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the class.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ClassAssertion that(final Class<?> actual) {
        ClassAssertion assertion = Raw.classAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the char sequence.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public CharSequenceAssertion that(final CharSequence actual) {
        CharSequenceAssertion assertion = Raw.charSequenceAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the string.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public StringAssertion that(final String actual) {
        StringAssertion assertion = Raw.stringAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the comparable.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ComparableAssertion that(final Comparable<?> actual) {
        ComparableAssertion assertion = Raw.comparableAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the iterable.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public IterableAssertion that(final Iterable<?> actual) {
        IterableAssertion assertion = Raw.iterableAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the throwable.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ThrowableAssertion that(final Throwable actual) {
        ThrowableAssertion assertion = Raw.throwableAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the collection.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public CollectionAssertion that(final Collection<?> actual) {
        CollectionAssertion assertion = Raw.collectionAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the iterator.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public IteratorAssertion that(final Iterator<?> actual) {
        IteratorAssertion assertion = Raw.iteratorAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the list.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ListAssertion that(final List<?> actual) {
        ListAssertion assertion = Raw.listAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the set.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public SetAssertion that(final Set<?> actual) {
        SetAssertion assertion = Raw.setAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the map.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public MapAssertion that(final Map<?, ?> actual) {
        MapAssertion assertion = Raw.mapAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the input stream.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public InputStreamAssertion that(final InputStream actual) {
        InputStreamAssertion assertion = Raw.inputStreamAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the reader.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ReaderAssertion that(final Reader actual) {
        ReaderAssertion assertion = Raw.readerAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the byte buffer.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ByteBufferAssertion that(final ByteBuffer actual) {
        ByteBufferAssertion assertion = Raw.byteBufferAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the short buffer.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ShortBufferAssertion that(final ShortBuffer actual) {
        ShortBufferAssertion assertion = Raw.shortBufferAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the int buffer.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public IntBufferAssertion that(final IntBuffer actual) {
        IntBufferAssertion assertion = Raw.intBufferAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the long buffer.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public LongBufferAssertion that(final LongBuffer actual) {
        LongBufferAssertion assertion = Raw.longBufferAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the float buffer.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public FloatBufferAssertion that(final FloatBuffer actual) {
        FloatBufferAssertion assertion = Raw.floatBufferAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the double buffer.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public DoubleBufferAssertion that(final DoubleBuffer actual) {
        DoubleBufferAssertion assertion = Raw.doubleBufferAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

    /**
     * Make assertion about the char buffer.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public CharBufferAssertion that(final CharBuffer actual) {
        CharBufferAssertion assertion = Raw.charBufferAssertion();
        assertion.initialize(actual, _message);
        return assertion;
    }

}
