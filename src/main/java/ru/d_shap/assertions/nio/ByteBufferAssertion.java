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
package ru.d_shap.assertions.nio;

import java.nio.ByteBuffer;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.array.ByteArrayAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the byte buffer.
 *
 * @author Dmitry Shapovalov
 */
public class ByteBufferAssertion extends ReferenceAssertion<ByteBuffer> {

    /**
     * Create new object.
     */
    public ByteBufferAssertion() {
        super();
    }

    @Override
    protected final Class<ByteBuffer> getActualValueClass() {
        return ByteBuffer.class;
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).isEmpty();
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isRewindAndEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).isEmpty();
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        checkInitialized();
        if (getActual() != null) {
            createByteArrayAssertion(false).isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isRewindAndNullOrEmpty() {
        checkInitialized();
        if (getActual() != null) {
            createByteArrayAssertion(true).isNullOrEmpty();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).isNotEmpty();
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isRewindAndNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).isNotEmpty();
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).contains((byte) expected);
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void rewindAndContains(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).contains((byte) expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).doesNotContain((byte) expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void rewindAndDoesNotContain(final int expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).doesNotContain((byte) expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAll(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAll(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAll(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAllInOrder(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAllInOrder(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAllInOrder(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactly(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactly(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactly(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactlyInOrder(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactlyInOrder(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactlyInOrder(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAny(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAny(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAny(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(false).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsNone(final byte... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsNone(final int... expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsNone(final Iterable<Byte> expected) {
        checkInitialized();
        checkActualIsNotNull();
        createByteArrayAssertion(true).containsNone(expected);
    }

    private ByteArrayAssertion createByteArrayAssertion(final boolean rewind) {
        byte[] bytes = convertValue(getActual(), byte[].class, rewind);
        return initializeAssertion(Raw.byteArrayAssertion(), bytes);
    }

    /**
     * Make assertion about the actual buffer's position.
     *
     * @return the assertion.
     */
    public final IntAssertion toPosition() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().position(), Messages.Check.ACTUAL_VALUE_POSITION);
    }

    /**
     * Check if the actual value position is equal to the expected position.
     *
     * @param expected the expected position.
     */
    public final void hasPosition(final int expected) {
        toPosition().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual buffer's limit.
     *
     * @return the assertion.
     */
    public final IntAssertion toLimit() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().limit(), Messages.Check.ACTUAL_VALUE_LIMIT);
    }

    /**
     * Check if the actual value limit is equal to the expected limit.
     *
     * @param expected the expected limit.
     */
    public final void hasLimit(final int expected) {
        toLimit().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual buffer's capacity.
     *
     * @return the assertion.
     */
    public final IntAssertion toCapacity() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().capacity(), Messages.Check.ACTUAL_VALUE_CAPACITY);
    }

    /**
     * Check if the actual value capacity is equal to the expected capacity.
     *
     * @param expected the expected capacity.
     */
    public final void hasCapacity(final int expected) {
        toCapacity().isEqualTo(expected);
    }

    /**
     * Check if the actual value properties is equal to the expected properties.
     *
     * @param expectedPosition the expected position.
     * @param expectedLimit    the expected limit.
     * @param expectedCapacity the expected capacity.
     */
    public final void hasProperties(final int expectedPosition, final int expectedLimit, final int expectedCapacity) {
        hasPosition(expectedPosition);
        hasLimit(expectedLimit);
        hasCapacity(expectedCapacity);
    }

    /**
     * Make assertion about the actual buffer's remaining.
     *
     * @return the assertion.
     */
    public final IntAssertion toRemaining() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().remaining(), Messages.Check.ACTUAL_VALUE_REMAINING);
    }

    /**
     * Check if the actual value remaining is equal to the expected remaining.
     *
     * @param expected the expected remaining.
     */
    public final void hasRemaining(final int expected) {
        toRemaining().isEqualTo(expected);
    }

    /**
     * Check if the actual value is direct.
     */
    public final void isDirect() {
        checkInitialized();
        checkActualIsNotNull();
        if (!getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_DIRECT).build();
        }
    }

    /**
     * Check if the actual value is NOT direct.
     */
    public final void isNotDirect() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NOT_DIRECT).build();
        }
    }

    /**
     * Check if the actual value is read only.
     */
    public final void isReadOnly() {
        checkInitialized();
        checkActualIsNotNull();
        if (!getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_READ_ONLY).build();
        }
    }

    /**
     * Check if the actual value is NOT read only.
     */
    public final void isNotReadOnly() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.IS_NOT_READ_ONLY).build();
        }
    }

}
