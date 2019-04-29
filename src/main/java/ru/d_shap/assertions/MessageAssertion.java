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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import javax.xml.namespace.QName;

import org.hamcrest.Matcher;
import org.w3c.dom.Attr;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ru.d_shap.assertions.asimp.array.BooleanArrayAssertion;
import ru.d_shap.assertions.asimp.array.ByteArrayAssertion;
import ru.d_shap.assertions.asimp.array.CharArrayAssertion;
import ru.d_shap.assertions.asimp.array.DoubleArrayAssertion;
import ru.d_shap.assertions.asimp.array.FloatArrayAssertion;
import ru.d_shap.assertions.asimp.array.IntArrayAssertion;
import ru.d_shap.assertions.asimp.array.LongArrayAssertion;
import ru.d_shap.assertions.asimp.array.ObjectArrayAssertion;
import ru.d_shap.assertions.asimp.array.ShortArrayAssertion;
import ru.d_shap.assertions.asimp.java.io.BufferedReaderAssertion;
import ru.d_shap.assertions.asimp.java.io.InputStreamAssertion;
import ru.d_shap.assertions.asimp.java.io.ReaderAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.ClassAssertion;
import ru.d_shap.assertions.asimp.java.lang.ComparableAssertion;
import ru.d_shap.assertions.asimp.java.lang.IterableAssertion;
import ru.d_shap.assertions.asimp.java.lang.ObjectAssertion;
import ru.d_shap.assertions.asimp.java.lang.ThrowableAssertion;
import ru.d_shap.assertions.asimp.java.nio.ByteBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.CharBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.DoubleBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.FloatBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.IntBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.LongBufferAssertion;
import ru.d_shap.assertions.asimp.java.nio.ShortBufferAssertion;
import ru.d_shap.assertions.asimp.java.util.IteratorAssertion;
import ru.d_shap.assertions.asimp.java.util.ListAssertion;
import ru.d_shap.assertions.asimp.java.util.MapAssertion;
import ru.d_shap.assertions.asimp.java.util.SetAssertion;
import ru.d_shap.assertions.asimp.java.util.SortedMapAssertion;
import ru.d_shap.assertions.asimp.java.util.SortedSetAssertion;
import ru.d_shap.assertions.asimp.javax.xml.namespace.QNameAssertion;
import ru.d_shap.assertions.asimp.org.w3c.dom.AttrAssertion;
import ru.d_shap.assertions.asimp.org.w3c.dom.CharacterDataAssertion;
import ru.d_shap.assertions.asimp.org.w3c.dom.DocumentAssertion;
import ru.d_shap.assertions.asimp.org.w3c.dom.ElementAssertion;
import ru.d_shap.assertions.asimp.org.w3c.dom.NodeAssertion;
import ru.d_shap.assertions.asimp.primitive.BooleanAssertion;
import ru.d_shap.assertions.asimp.primitive.ByteAssertion;
import ru.d_shap.assertions.asimp.primitive.CharAssertion;
import ru.d_shap.assertions.asimp.primitive.DoubleAssertion;
import ru.d_shap.assertions.asimp.primitive.FloatAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;
import ru.d_shap.assertions.asimp.primitive.LongAssertion;
import ru.d_shap.assertions.asimp.primitive.ShortAssertion;

/**
 * Entry point of all assertions with the message.
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
     *
     * @return the assertion.
     */
    public ByteAssertion that(final byte actual) {
        ByteAssertion assertion = Raw.byteAssertion();
        ((BaseAssertion<Byte>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the byte.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ByteAssertion that(final Byte actual) {
        ByteAssertion assertion = Raw.byteAssertion();
        ((BaseAssertion<Byte>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the short.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ShortAssertion that(final short actual) {
        ShortAssertion assertion = Raw.shortAssertion();
        ((BaseAssertion<Short>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the short.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ShortAssertion that(final Short actual) {
        ShortAssertion assertion = Raw.shortAssertion();
        ((BaseAssertion<Short>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the int.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public IntAssertion that(final int actual) {
        IntAssertion assertion = Raw.intAssertion();
        ((BaseAssertion<Integer>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the int.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public IntAssertion that(final Integer actual) {
        IntAssertion assertion = Raw.intAssertion();
        ((BaseAssertion<Integer>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the long.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public LongAssertion that(final long actual) {
        LongAssertion assertion = Raw.longAssertion();
        ((BaseAssertion<Long>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the long.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public LongAssertion that(final Long actual) {
        LongAssertion assertion = Raw.longAssertion();
        ((BaseAssertion<Long>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the float.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public FloatAssertion that(final float actual) {
        FloatAssertion assertion = Raw.floatAssertion();
        ((BaseAssertion<Float>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the float.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public FloatAssertion that(final Float actual) {
        FloatAssertion assertion = Raw.floatAssertion();
        ((BaseAssertion<Float>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the double.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public DoubleAssertion that(final double actual) {
        DoubleAssertion assertion = Raw.doubleAssertion();
        ((BaseAssertion<Double>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the double.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public DoubleAssertion that(final Double actual) {
        DoubleAssertion assertion = Raw.doubleAssertion();
        ((BaseAssertion<Double>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the boolean.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public BooleanAssertion that(final boolean actual) {
        BooleanAssertion assertion = Raw.booleanAssertion();
        ((BaseAssertion<Boolean>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the boolean.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public BooleanAssertion that(final Boolean actual) {
        BooleanAssertion assertion = Raw.booleanAssertion();
        ((BaseAssertion<Boolean>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the char.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public CharAssertion that(final char actual) {
        CharAssertion assertion = Raw.charAssertion();
        ((BaseAssertion<Character>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the char.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public CharAssertion that(final Character actual) {
        CharAssertion assertion = Raw.charAssertion();
        ((BaseAssertion<Character>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the object.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ObjectAssertion that(final Object actual) {
        ObjectAssertion assertion = Raw.objectAssertion();
        ((BaseAssertion<Object>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion of specified type about the object.
     *
     * @param actual    the actual value.
     * @param assertion the assertion.
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the assertion.
     */
    public <W, S extends BaseAssertion<W>> S that(final Object actual, final S assertion) {
        return that(actual).as(assertion);
    }

    /**
     * Make assertion about the object with the hamcrest matcher.
     *
     * @param actual  the actual value.
     * @param matcher the hamcrest matcher.
     * @param <W>     the generic type of the matcher's actual value.
     * @param <U>     the generic type of the actual value.
     */
    public <W, U extends W> void that(final U actual, final Matcher<W> matcher) {
        HamcrestMatcher.matcherAssertion(actual, matcher, Messages.SIMPLE_MESSAGE, _message);
    }

    /**
     * Make assertion about the object's field.
     *
     * @param actual    the actual value.
     * @param fieldName the field name.
     *
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
     * @param <W>       the generic type of the assertion's actual value.
     * @param <S>       the generic type of the assertion.
     *
     * @return the assertion.
     */
    public <W, S extends BaseAssertion<W>> S that(final Object actual, final String fieldName, final S assertion) {
        return that(actual).toField(fieldName, assertion);
    }

    /**
     * Make assertion about the object's field with the hamcrest matcher.
     *
     * @param actual    the actual value.
     * @param fieldName the field name.
     * @param matcher   the hamcrest matcher.
     * @param <W>       the generic type of the matcher's actual value.
     */
    public <W> void that(final Object actual, final String fieldName, final Matcher<W> matcher) {
        that(actual).toField(fieldName, matcher);
    }

    /**
     * Make assertion about the byte array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ByteArrayAssertion that(final byte[] actual) {
        ByteArrayAssertion assertion = Raw.byteArrayAssertion();
        ((BaseAssertion<byte[]>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the short array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ShortArrayAssertion that(final short[] actual) {
        ShortArrayAssertion assertion = Raw.shortArrayAssertion();
        ((BaseAssertion<short[]>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the int array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public IntArrayAssertion that(final int[] actual) {
        IntArrayAssertion assertion = Raw.intArrayAssertion();
        ((BaseAssertion<int[]>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the long array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public LongArrayAssertion that(final long[] actual) {
        LongArrayAssertion assertion = Raw.longArrayAssertion();
        ((BaseAssertion<long[]>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the float array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public FloatArrayAssertion that(final float[] actual) {
        FloatArrayAssertion assertion = Raw.floatArrayAssertion();
        ((BaseAssertion<float[]>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the double array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public DoubleArrayAssertion that(final double[] actual) {
        DoubleArrayAssertion assertion = Raw.doubleArrayAssertion();
        ((BaseAssertion<double[]>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the boolean array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public BooleanArrayAssertion that(final boolean[] actual) {
        BooleanArrayAssertion assertion = Raw.booleanArrayAssertion();
        ((BaseAssertion<boolean[]>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the char array.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public CharArrayAssertion that(final char[] actual) {
        CharArrayAssertion assertion = Raw.charArrayAssertion();
        ((BaseAssertion<char[]>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the object array.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public <E> ObjectArrayAssertion<E> that(final E[] actual) {
        ObjectArrayAssertion<E> assertion = Raw.objectArrayAssertion();
        ((BaseAssertion<E[]>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the class.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ClassAssertion that(final Class<?> actual) {
        ClassAssertion assertion = Raw.classAssertion();
        ((BaseAssertion<Class<?>>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the char sequence.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion that(final CharSequence actual) {
        CharSequenceAssertion assertion = Raw.charSequenceAssertion();
        ((BaseAssertion<CharSequence>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the string.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion that(final String actual) {
        CharSequenceAssertion assertion = Raw.charSequenceAssertion();
        ((BaseAssertion<CharSequence>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the comparable.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public <E> ComparableAssertion<E> that(final Comparable<E> actual) {
        ComparableAssertion<E> assertion = Raw.comparableAssertion();
        ((BaseAssertion<Comparable<E>>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the iterable.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public <E> IterableAssertion<E> that(final Iterable<E> actual) {
        IterableAssertion<E> assertion = Raw.iterableAssertion();
        ((BaseAssertion<Iterable<E>>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the throwable.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ThrowableAssertion that(final Throwable actual) {
        ThrowableAssertion assertion = Raw.throwableAssertion();
        ((BaseAssertion<Throwable>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the iterator.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public <E> IteratorAssertion<E> that(final Iterator<E> actual) {
        IteratorAssertion<E> assertion = Raw.iteratorAssertion();
        ((BaseAssertion<Iterator<E>>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the list.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public <E> ListAssertion<E> that(final List<E> actual) {
        ListAssertion<E> assertion = Raw.listAssertion();
        ((BaseAssertion<List<E>>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the set.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public <E> SetAssertion<E> that(final Set<E> actual) {
        SetAssertion<E> assertion = Raw.setAssertion();
        ((BaseAssertion<Set<E>>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the sorted set.
     *
     * @param actual the actual value.
     * @param <E>    the generic type of the element.
     *
     * @return the assertion.
     */
    public <E> SortedSetAssertion<E> that(final SortedSet<E> actual) {
        SortedSetAssertion<E> assertion = Raw.sortedSetAssertion();
        ((BaseAssertion<SortedSet<E>>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the map.
     *
     * @param actual the actual value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     *
     * @return the assertion.
     */
    public <K, V> MapAssertion<K, V> that(final Map<K, V> actual) {
        MapAssertion<K, V> assertion = Raw.mapAssertion();
        ((BaseAssertion<Map<K, V>>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the sorted map.
     *
     * @param actual the actual value.
     * @param <K>    the generic type of the key.
     * @param <V>    the generic type of the value.
     *
     * @return the assertion.
     */
    public <K, V> SortedMapAssertion<K, V> that(final SortedMap<K, V> actual) {
        SortedMapAssertion<K, V> assertion = Raw.sortedMapAssertion();
        ((BaseAssertion<SortedMap<K, V>>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the input stream.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public InputStreamAssertion that(final InputStream actual) {
        InputStreamAssertion assertion = Raw.inputStreamAssertion();
        ((BaseAssertion<InputStream>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the reader.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ReaderAssertion that(final Reader actual) {
        ReaderAssertion assertion = Raw.readerAssertion();
        ((BaseAssertion<Reader>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the buffered reader.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public BufferedReaderAssertion that(final BufferedReader actual) {
        BufferedReaderAssertion assertion = Raw.bufferedReaderAssertion();
        ((BaseAssertion<BufferedReader>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the byte buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ByteBufferAssertion that(final ByteBuffer actual) {
        ByteBufferAssertion assertion = Raw.byteBufferAssertion();
        ((BaseAssertion<ByteBuffer>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the short buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ShortBufferAssertion that(final ShortBuffer actual) {
        ShortBufferAssertion assertion = Raw.shortBufferAssertion();
        ((BaseAssertion<ShortBuffer>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the int buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public IntBufferAssertion that(final IntBuffer actual) {
        IntBufferAssertion assertion = Raw.intBufferAssertion();
        ((BaseAssertion<IntBuffer>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the long buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public LongBufferAssertion that(final LongBuffer actual) {
        LongBufferAssertion assertion = Raw.longBufferAssertion();
        ((BaseAssertion<LongBuffer>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the float buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public FloatBufferAssertion that(final FloatBuffer actual) {
        FloatBufferAssertion assertion = Raw.floatBufferAssertion();
        ((BaseAssertion<FloatBuffer>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the double buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public DoubleBufferAssertion that(final DoubleBuffer actual) {
        DoubleBufferAssertion assertion = Raw.doubleBufferAssertion();
        ((BaseAssertion<DoubleBuffer>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the char buffer.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public CharBufferAssertion that(final CharBuffer actual) {
        CharBufferAssertion assertion = Raw.charBufferAssertion();
        ((BaseAssertion<CharBuffer>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the qname.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public QNameAssertion that(final QName actual) {
        QNameAssertion assertion = Raw.qnameAssertion();
        ((BaseAssertion<QName>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the node.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public NodeAssertion that(final Node actual) {
        NodeAssertion assertion = Raw.nodeAssertion();
        ((BaseAssertion<Node>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the element.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public ElementAssertion that(final Element actual) {
        ElementAssertion assertion = Raw.elementAssertion();
        ((BaseAssertion<Element>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the document.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public DocumentAssertion that(final Document actual) {
        DocumentAssertion assertion = Raw.documentAssertion();
        ((BaseAssertion<Document>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the attr.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public AttrAssertion that(final Attr actual) {
        AttrAssertion assertion = Raw.attrAssertion();
        ((BaseAssertion<Attr>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

    /**
     * Make assertion about the character data.
     *
     * @param actual the actual value.
     *
     * @return the assertion.
     */
    public CharacterDataAssertion that(final CharacterData actual) {
        CharacterDataAssertion assertion = Raw.characterDataAssertion();
        ((BaseAssertion<CharacterData>) assertion).initialize(actual, Messages.SIMPLE_MESSAGE, _message);
        return assertion;
    }

}
