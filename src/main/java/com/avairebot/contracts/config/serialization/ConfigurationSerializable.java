/*
 * Copyright (c) 2018.
 *
 * This file is part of AvaIre.
 *
 * AvaIre is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AvaIre is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AvaIre.  If not, see <https://www.gnu.org/licenses/>.
 *
 *
 */

package com.avairebot.contracts.config.serialization;

import com.avairebot.config.serialization.ConfigurationSerialization;

import java.util.Map;

/**
 * Represents an object that may be serialized.
 * <p>
 * These objects MUST implement one of the following, in addition to the
 * methods as defined by this interface:
 * <ul>
 * <li>A static method "deserialize" that accepts a single {@link Map}&lt;
 * {@link String}, {@link Object}&gt; and returns the class.</li>
 * <li>A static method "valueOf" that accepts a single {@link Map}&lt;{@link
 * String}, {@link Object}&gt; and returns the class.</li>
 * <li>A constructor that accepts a single {@link Map}&lt;{@link String},
 * {@link Object}&gt;.</li>
 * </ul>
 * In addition to implementing this interface, you must register the class
 * with {@link ConfigurationSerialization#registerClass(Class)}.
 *
 * @see DelegateDeserialization
 * @see SerializableAs
 */
public interface ConfigurationSerializable {

    /**
     * Creates a Map representation of this class.
     * <p>
     * This class must provide a method to restore this class, as defined in
     * the {@link ConfigurationSerializable} interface javadocs.
     *
     * @return Map containing the current state of this class
     */
    Map<String, Object> serialize();
}
