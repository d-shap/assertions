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
import ru.d_shap.assertions.asimp.java.lang.EnumAssertion;
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
import ru.d_shap.assertions.asimp.java.util.CalendarAssertion;
import ru.d_shap.assertions.asimp.java.util.DateAssertion;
import ru.d_shap.assertions.asimp.java.util.IteratorAssertion;
import ru.d_shap.assertions.asimp.java.util.ListAssertion;
import ru.d_shap.assertions.asimp.java.util.LocaleAssertion;
import ru.d_shap.assertions.asimp.java.util.MapAssertion;
import ru.d_shap.assertions.asimp.java.util.SetAssertion;
import ru.d_shap.assertions.asimp.java.util.SortedMapAssertion;
import ru.d_shap.assertions.asimp.java.util.SortedSetAssertion;
import ru.d_shap.assertions.asimp.java.util.TimeZoneAssertion;
import ru.d_shap.assertions.asimp.javax.xml.datatype.XMLGregorianCalendarAssertion;
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
     *
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
     * Create uninitialized assertion about the comparable.
     *
     * @param <E> the generic type of the element.
     *
     * @return the assertion.
     */
    public static <E> ComparableAssertion<E> comparableAssertion() {
        return new ComparableAssertion<>();
    }

    /**
     * Create uninitialized assertion about the iterable.
     *
     * @param <E> the generic type of the element.
     *
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
     *
     * @return the assertion.
     */
    public static <E> IteratorAssertion<E> iteratorAssertion() {
        return new IteratorAssertion<>();
    }

    /**
     * Create uninitialized assertion about the list.
     *
     * @param <E> the generic type of the element.
     *
     * @return the assertion.
     */
    public static <E> ListAssertion<E> listAssertion() {
        return new ListAssertion<>();
    }

    /**
     * Create uninitialized assertion about the set.
     *
     * @param <E> the generic type of the element.
     *
     * @return the assertion.
     */
    public static <E> SetAssertion<E> setAssertion() {
        return new SetAssertion<>();
    }

    /**
     * Create uninitialized assertion about the sorted set.
     *
     * @param <E> the generic type of the element.
     *
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
     *
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
     *
     * @return the assertion.
     */
    public static <K, V> SortedMapAssertion<K, V> sortedMapAssertion() {
        return new SortedMapAssertion<>();
    }

    /**
     * Create uninitialized assertion about the date.
     *
     * @return the assertion.
     */
    public static DateAssertion dateAssertion() {
        return new DateAssertion();
    }

    /**
     * Create uninitialized assertion about the calendar.
     *
     * @return the assertion.
     */
    public static CalendarAssertion calendarAssertion() {
        return new CalendarAssertion();
    }

    /**
     * Create uninitialized assertion about the time zone.
     *
     * @return the assertion.
     */
    public static TimeZoneAssertion timeZoneAssertion() {
        return new TimeZoneAssertion();
    }

    /**
     * Create uninitialized assertion about the locale.
     *
     * @return the assertion.
     */
    public static LocaleAssertion localeAssertion() {
        return new LocaleAssertion();
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
     * Create uninitialized assertion about the buffered reader.
     *
     * @return the assertion.
     */
    public static BufferedReaderAssertion bufferedReaderAssertion() {
        return new BufferedReaderAssertion();
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

    /**
     * Create uninitialized assertion about the XML gregorian calendar.
     *
     * @return the assertion.
     */
    public static XMLGregorianCalendarAssertion xmlGregorianCalendarAssertion() {
        return new XMLGregorianCalendarAssertion();
    }

    /**
     * Create uninitialized assertion about the qname.
     *
     * @return the assertion.
     */
    public static QNameAssertion qnameAssertion() {
        return new QNameAssertion();
    }

    /**
     * Create uninitialized assertion about the node.
     *
     * @return the assertion.
     */
    public static NodeAssertion nodeAssertion() {
        return new NodeAssertion();
    }

    /**
     * Create uninitialized assertion about the element.
     *
     * @return the assertion.
     */
    public static ElementAssertion elementAssertion() {
        return new ElementAssertion();
    }

    /**
     * Create uninitialized assertion about the document.
     *
     * @return the assertion.
     */
    public static DocumentAssertion documentAssertion() {
        return new DocumentAssertion();
    }

    /**
     * Create uninitialized assertion about the attr.
     *
     * @return the assertion.
     */
    public static AttrAssertion attrAssertion() {
        return new AttrAssertion();
    }

    /**
     * Create uninitialized assertion about the character data.
     *
     * @return the assertion.
     */
    public static CharacterDataAssertion characterDataAssertion() {
        return new CharacterDataAssertion();
    }

}
