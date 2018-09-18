package com.codecool;

import com.codecool.hasher.BetterStringHasher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    private HashTable hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable(16, new BetterStringHasher());
    }

    @Test
    void lookup_true() {
        String text = "test";
        hashTable.add(text);

        assertTrue(hashTable.lookup(text));
    }

    @Test
    void lookup_false() {
        assertFalse(hashTable.lookup("test"));
    }

    @Test
    void remove() {
        String text = "test";
        hashTable.add(text);
        hashTable.remove(text);

        assertFalse(hashTable.lookup(text));
    }

    @Test
    void remove_illegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> hashTable.remove("test"));
    }

}