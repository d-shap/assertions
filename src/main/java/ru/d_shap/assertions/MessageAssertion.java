///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
public final class MessageAssertion extends BaseAssertion {

    MessageAssertion(final String message) {
        super(null, message);
    }

    /**
     * Make assertion about the byte.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ByteAssertion that(final byte actual) {
        return new ByteAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the short.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ShortAssertion that(final short actual) {
        return new ShortAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the int.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public IntAssertion that(final int actual) {
        return new IntAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the long.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public LongAssertion that(final long actual) {
        return new LongAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the float.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public FloatAssertion that(final float actual) {
        return new FloatAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the double.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public DoubleAssertion that(final double actual) {
        return new DoubleAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the boolean.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public BooleanAssertion that(final boolean actual) {
        return new BooleanAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the char.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public CharAssertion that(final char actual) {
        return new CharAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the object.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ObjectAssertion that(final Object actual) {
        return new ObjectAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the byte array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ByteArrayAssertion that(final byte[] actual) {
        return new ByteArrayAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the short array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ShortArrayAssertion that(final short[] actual) {
        return new ShortArrayAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the int array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public IntArrayAssertion that(final int[] actual) {
        return new IntArrayAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the long array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public LongArrayAssertion that(final long[] actual) {
        return new LongArrayAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the float array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public FloatArrayAssertion that(final float[] actual) {
        return new FloatArrayAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the double array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public DoubleArrayAssertion that(final double[] actual) {
        return new DoubleArrayAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the boolean array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public BooleanArrayAssertion that(final boolean[] actual) {
        return new BooleanArrayAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the char array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public CharArrayAssertion that(final char[] actual) {
        return new CharArrayAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the object array.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ObjectArrayAssertion that(final Object[] actual) {
        return new ObjectArrayAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the class.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ClassAssertion that(final Class<?> actual) {
        return new ClassAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the char sequence.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public CharSequenceAssertion that(final CharSequence actual) {
        return new CharSequenceAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the string.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public StringAssertion that(final String actual) {
        return new StringAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the comparable.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ComparableAssertion that(final Comparable<?> actual) {
        return new ComparableAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the iterable.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public IterableAssertion that(final Iterable<?> actual) {
        return new IterableAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the throwable.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ThrowableAssertion that(final Throwable actual) {
        return new ThrowableAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the collection.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public CollectionAssertion that(final Collection<?> actual) {
        return new CollectionAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the iterator.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public IteratorAssertion that(final Iterator<?> actual) {
        return new IteratorAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the list.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public ListAssertion that(final List<?> actual) {
        return new ListAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the set.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public SetAssertion that(final Set<?> actual) {
        return new SetAssertion(actual, getMessage());
    }

    /**
     * Make assertion about the map.
     *
     * @param actual the actual value.
     * @return the assertion.
     */
    public MapAssertion that(final Map<?, ?> actual) {
        return new MapAssertion(actual, getMessage());
    }

    @Override
    protected String asString(final Object value) {
        return null;
    }

}
