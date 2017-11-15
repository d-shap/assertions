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
 * Class to create uninitialized assertion objects.
 *
 * @author Dmitry Shapovalov
 */
public final class Raw {

    private Raw() {
        super();
    }

    public static ByteAssertion byteAssertion() {
        return new ByteAssertion();
    }

    public static ShortAssertion shortAssertion() {
        return new ShortAssertion();
    }

    public static IntAssertion intAssertion() {
        return new IntAssertion();
    }

    public static LongAssertion longAssertion() {
        return new LongAssertion();
    }

    public static FloatAssertion floatAssertion() {
        return new FloatAssertion();
    }

    public static DoubleAssertion doubleAssertion() {
        return new DoubleAssertion();
    }

    public static BooleanAssertion booleanAssertion() {
        return new BooleanAssertion();
    }

    public static CharAssertion charAssertion() {
        return new CharAssertion();
    }

    public static ObjectAssertion objectAssertion() {
        return new ObjectAssertion();
    }

    public static ByteArrayAssertion byteArrayAssertion() {
        return new ByteArrayAssertion();
    }

    public static ShortArrayAssertion shortArrayAssertion() {
        return new ShortArrayAssertion();
    }

    public static IntArrayAssertion intArrayAssertion() {
        return new IntArrayAssertion();
    }

    public static LongArrayAssertion longArrayAssertion() {
        return new LongArrayAssertion();
    }

    public static FloatArrayAssertion floatArrayAssertion() {
        return new FloatArrayAssertion();
    }

    public static DoubleArrayAssertion doubleArrayAssertion() {
        return new DoubleArrayAssertion();
    }

    public static BooleanArrayAssertion booleanArrayAssertion() {
        return new BooleanArrayAssertion();
    }

    public static CharArrayAssertion charArrayAssertion() {
        return new CharArrayAssertion();
    }

    public static ObjectArrayAssertion objectArrayAssertion() {
        return new ObjectArrayAssertion();
    }

    public static ClassAssertion classAssertion() {
        return new ClassAssertion();
    }

    public static CharSequenceAssertion charSequenceAssertion() {
        return new CharSequenceAssertion();
    }

    public static StringAssertion stringAssertion() {
        return new StringAssertion();
    }

    public static ComparableAssertion comparableAssertion() {
        return new ComparableAssertion();
    }

    public static IterableAssertion iterableAssertion() {
        return new IterableAssertion();
    }

    public static ThrowableAssertion throwableAssertion() {
        return new ThrowableAssertion();
    }

    public static CollectionAssertion collectionAssertion() {
        return new CollectionAssertion();
    }

    public static IteratorAssertion iteratorAssertion() {
        return new IteratorAssertion();
    }

    public static ListAssertion listAssertion() {
        return new ListAssertion();
    }

    public static SetAssertion setAssertion() {
        return new SetAssertion();
    }

    public static MapAssertion mapAssertion() {
        return new MapAssertion();
    }

    public static InputStreamAssertion inputStreamAssertion() {
        return new InputStreamAssertion();
    }

    public static ReaderAssertion readerAssertion() {
        return new ReaderAssertion();
    }

    public static ByteBufferAssertion byteBufferAssertion() {
        return new ByteBufferAssertion();
    }

    public static ShortBufferAssertion shortBufferAssertion() {
        return new ShortBufferAssertion();
    }

    public static IntBufferAssertion intBufferAssertion() {
        return new IntBufferAssertion();
    }

    public static LongBufferAssertion longBufferAssertion() {
        return new LongBufferAssertion();
    }

    public static FloatBufferAssertion floatBufferAssertion() {
        return new FloatBufferAssertion();
    }

    public static DoubleBufferAssertion doubleBufferAssertion() {
        return new DoubleBufferAssertion();
    }

    public static CharBufferAssertion charBufferAssertion() {
        return new CharBufferAssertion();
    }

}
