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

import ru.d_shap.assertions.array.BooleanArrayAssertion;
import ru.d_shap.assertions.array.ByteArrayAssertion;
import ru.d_shap.assertions.array.CharArrayAssertion;
import ru.d_shap.assertions.array.DoubleArrayAssertion;
import ru.d_shap.assertions.array.FloatArrayAssertion;
import ru.d_shap.assertions.array.IntArrayAssertion;
import ru.d_shap.assertions.array.LongArrayAssertion;
import ru.d_shap.assertions.array.ObjectArrayAssertion;
import ru.d_shap.assertions.array.ShortArrayAssertion;
import ru.d_shap.assertions.collection.IteratorAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.collection.MapAssertion;
import ru.d_shap.assertions.collection.SetAssertion;
import ru.d_shap.assertions.collection.SortedMapAssertion;
import ru.d_shap.assertions.collection.SortedSetAssertion;
import ru.d_shap.assertions.core.CharSequenceAssertion;
import ru.d_shap.assertions.core.ClassAssertion;
import ru.d_shap.assertions.core.ComparableAssertion;
import ru.d_shap.assertions.core.EnumAssertion;
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
 * Class to create uninitialized assertions.
 *
 * @author Dmitry Shapovalov
 */
public final class Raw {

    private Raw() {
        super();
    }

    /**
     * Create uninitialized assertion about the byte.
     *
     * @return the assertion.
     */
    public static ByteAssertion byteAssertion() {
        return new ByteAssertion();
    }

    /**
     * Create uninitialized assertion about the short.
     *
     * @return the assertion.
     */
    public static ShortAssertion shortAssertion() {
        return new ShortAssertion();
    }

    /**
     * Create uninitialized assertion about the int.
     *
     * @return the assertion.
     */
    public static IntAssertion intAssertion() {
        return new IntAssertion();
    }

    /**
     * Create uninitialized assertion about the long.
     *
     * @return the assertion.
     */
    public static LongAssertion longAssertion() {
        return new LongAssertion();
    }

    /**
     * Create uninitialized assertion about the float.
     *
     * @return the assertion.
     */
    public static FloatAssertion floatAssertion() {
        return new FloatAssertion();
    }

    /**
     * Create uninitialized assertion about the double.
     *
     * @return the assertion.
     */
    public static DoubleAssertion doubleAssertion() {
        return new DoubleAssertion();
    }

    /**
     * Create uninitialized assertion about the boolean.
     *
     * @return the assertion.
     */
    public static BooleanAssertion booleanAssertion() {
        return new BooleanAssertion();
    }

    /**
     * Create uninitialized assertion about the char.
     *
     * @return the assertion.
     */
    public static CharAssertion charAssertion() {
        return new CharAssertion();
    }

    /**
     * Create uninitialized assertion about the object.
     *
     * @return the assertion.
     */
    public static ObjectAssertion objectAssertion() {
        return new ObjectAssertion();
    }

    /**
     * Create uninitialized assertion about the byte array.
     *
     * @return the assertion.
     */
    public static ByteArrayAssertion byteArrayAssertion() {
        return new ByteArrayAssertion();
    }

    /**
     * Create uninitialized assertion about the short array.
     *
     * @return the assertion.
     */
    public static ShortArrayAssertion shortArrayAssertion() {
        return new ShortArrayAssertion();
    }

    /**
     * Create uninitialized assertion about the int array.
     *
     * @return the assertion.
     */
    public static IntArrayAssertion intArrayAssertion() {
        return new IntArrayAssertion();
    }

    /**
     * Create uninitialized assertion about the long array.
     *
     * @return the assertion.
     */
    public static LongArrayAssertion longArrayAssertion() {
        return new LongArrayAssertion();
    }

    /**
     * Create uninitialized assertion about the float array.
     *
     * @return the assertion.
     */
    public static FloatArrayAssertion floatArrayAssertion() {
        return new FloatArrayAssertion();
    }

    /**
     * Create uninitialized assertion about the double array.
     *
     * @return the assertion.
     */
    public static DoubleArrayAssertion doubleArrayAssertion() {
        return new DoubleArrayAssertion();
    }

    /**
     * Create uninitialized assertion about the boolean array.
     *
     * @return the assertion.
     */
    public static BooleanArrayAssertion booleanArrayAssertion() {
        return new BooleanArrayAssertion();
    }

    /**
     * Create uninitialized assertion about the char array.
     *
     * @return the assertion.
     */
    public static CharArrayAssertion charArrayAssertion() {
        return new CharArrayAssertion();
    }

    /**
     * Create uninitialized assertion about the object array.
     *
     * @param <E> the generic type of the element.
     * @return the assertion.
     */
    public static <E> ObjectArrayAssertion<E> objectArrayAssertion() {
        return new ObjectArrayAssertion<>();
    }

    /**
     * Create uninitialized assertion about the class.
     *
     * @return the assertion.
     */
    public static ClassAssertion classAssertion() {
        return new ClassAssertion();
    }

    /**
     * Create uninitialized assertion about the enum.
     *
     * @return the assertion.
     */
    public static EnumAssertion enumAssertion() {
        return new EnumAssertion();
    }

    /**
     * Create uninitialized assertion about the char sequence.
     *
     * @return the assertion.
     */
    public static CharSequenceAssertion charSequenceAssertion() {
        return new CharSequenceAssertion();
    }

    /**
     * Create uninitialized assertion about the string.
     *
     * @return the assertion.
     */
    public static StringAssertion stringAssertion() {
        return new StringAssertion();
    }

    /**
     * Create uninitialized assertion about the comparable.
     *
     * @param <E> the generic type of the element.
     * @return the assertion.
     */
    public static <E> ComparableAssertion<E> comparableAssertion() {
        return new ComparableAssertion<>();
    }

    /**
     * Create uninitialized assertion about the iterable.
     *
     * @param <E> the generic type of the element.
     * @return the assertion.
     */
    public static <E> IterableAssertion<E> iterableAssertion() {
        return new IterableAssertion<>();
    }

    /**
     * Create uninitialized assertion about the throwable.
     *
     * @return the assertion.
     */
    public static ThrowableAssertion throwableAssertion() {
        return new ThrowableAssertion();
    }

    /**
     * Create uninitialized assertion about the iterator.
     *
     * @param <E> the generic type of the element.
     * @return the assertion.
     */
    public static <E> IteratorAssertion<E> iteratorAssertion() {
        return new IteratorAssertion<>();
    }

    /**
     * Create uninitialized assertion about the list.
     *
     * @param <E> the generic type of the element.
     * @return the assertion.
     */
    public static <E> ListAssertion<E> listAssertion() {
        return new ListAssertion<>();
    }

    /**
     * Create uninitialized assertion about the set.
     *
     * @param <E> the generic type of the element.
     * @return the assertion.
     */
    public static <E> SetAssertion<E> setAssertion() {
        return new SetAssertion<>();
    }

    /**
     * Create uninitialized assertion about the sorted set.
     *
     * @param <E> the generic type of the element.
     * @return the assertion.
     */
    public static <E> SortedSetAssertion<E> sortedSetAssertion() {
        return new SortedSetAssertion<>();
    }

    /**
     * Create uninitialized assertion about the map.
     *
     * @param <K> the generic type of the key.
     * @param <V> the generic type of the value.
     * @return the assertion.
     */
    public static <K, V> MapAssertion<K, V> mapAssertion() {
        return new MapAssertion<>();
    }

    /**
     * Create uninitialized assertion about the sorted map.
     *
     * @param <K> the generic type of the key.
     * @param <V> the generic type of the value.
     * @return the assertion.
     */
    public static <K, V> SortedMapAssertion<K, V> sortedMapAssertion() {
        return new SortedMapAssertion<>();
    }

    /**
     * Create uninitialized assertion about the input stream.
     *
     * @return the assertion.
     */
    public static InputStreamAssertion inputStreamAssertion() {
        return new InputStreamAssertion();
    }

    /**
     * Create uninitialized assertion about the reader.
     *
     * @return the assertion.
     */
    public static ReaderAssertion readerAssertion() {
        return new ReaderAssertion();
    }

    /**
     * Create uninitialized assertion about the byte buffer.
     *
     * @return the assertion.
     */
    public static ByteBufferAssertion byteBufferAssertion() {
        return new ByteBufferAssertion();
    }

    /**
     * Create uninitialized assertion about the short buffer.
     *
     * @return the assertion.
     */
    public static ShortBufferAssertion shortBufferAssertion() {
        return new ShortBufferAssertion();
    }

    /**
     * Create uninitialized assertion about the int buffer.
     *
     * @return the assertion.
     */
    public static IntBufferAssertion intBufferAssertion() {
        return new IntBufferAssertion();
    }

    /**
     * Create uninitialized assertion about the long buffer.
     *
     * @return the assertion.
     */
    public static LongBufferAssertion longBufferAssertion() {
        return new LongBufferAssertion();
    }

    /**
     * Create uninitialized assertion about the float buffer.
     *
     * @return the assertion.
     */
    public static FloatBufferAssertion floatBufferAssertion() {
        return new FloatBufferAssertion();
    }

    /**
     * Create uninitialized assertion about the double buffer.
     *
     * @return the assertion.
     */
    public static DoubleBufferAssertion doubleBufferAssertion() {
        return new DoubleBufferAssertion();
    }

    /**
     * Create uninitialized assertion about the char buffer.
     *
     * @return the assertion.
     */
    public static CharBufferAssertion charBufferAssertion() {
        return new CharBufferAssertion();
    }

}
