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
package ru.d_shap.assertions.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Helper class to perform serialization and deserialization operations.
 *
 * @author Dmitry Shapovalov
 */
public final class SerializationHelper {

    private SerializationHelper() {
        super();
    }

    /**
     * Serialize the specified object to the byte array.
     *
     * @param object the specified object.
     * @param <T>    the generic type of the specified object.
     *
     * @return the byte array.
     */
    public static <T> byte[] serialize(final T object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (IOException ex) {
            throw new SerializationException(ex);
        }
    }

    /**
     * Deserialize the object from the byte array.
     *
     * @param bytes the byte array.
     * @param <T>   the generic type of the object.
     *
     * @return the object deserialized from the byte array.
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(final byte[] bytes) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new SerializationException(ex);
        }
    }

    /**
     * Serialize the specified object and deserialize it back.
     *
     * @param object the specified object.
     * @param <T>    the generic type of the specified object.
     *
     * @return the deserialized object.
     */
    public static <T> T serializeAndDeserialize(final T object) {
        byte[] bytes = serialize(object);
        return deserialize(bytes);
    }

}
