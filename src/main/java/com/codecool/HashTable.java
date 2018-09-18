/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * Implement your hash table here.  You are required to use the separate
 * chaining strategy that we discussed in lecture, meaning that collisions
 * are resolved by having each cell in the table be a linked list of all of
 * the strings that hashed to that cell.
 */
package com.codecool;

import com.codecool.hasher.StringHasher;

public class HashTable {
    private int tableSize;
	private StringHasher hasher;
	private Node[] elements;
	/**
    * The constructor is given a table size (i.e. how big to make the array)
    * and a StringHasher, which is used to hash the strings.
    *
    * @param tableSize number of elements in the hash array
    *        hasher    Object that creates the hash code for a string
    * @see StringHasher
    */
	public HashTable(int tableSize, StringHasher hasher) {
	    this.tableSize = tableSize;
        this.elements = new Node[tableSize];
        this.hasher = hasher;
	}


 	/**
    * Takes a string and adds it to the hash table, if it's not already
    * in the hash table.  If it is, this method has no effect.
    *
    * @param s String to add
    */
	public void add(String s) {
        int index =  calculateIndex(s);

	    Node node = elements[index];
	    Node nodeToAdd = new Node(hasher.hash(s), s);
	    if (node == null) {
	        elements[index] = nodeToAdd;
        } else {
	        while (node.getNext() != null) {
	            node = node.getNext();
            }
            node.setNext(nodeToAdd);
        }
	}
	

	/**
    * Takes a string and returns true if that string appears in the
    * hash table, false otherwise.
    *
    * @param s String to look up
    */
	public boolean lookup(String s)  {
	    int index = calculateIndex(s);
	    Node node = elements[index];
	    while (node != null) {
	        if (node.getValue().equals(s)) {
	            return true;
            }
            node = node.getNext();
        }
        return false;
	}

	private int calculateIndex(String s) {
        int index =  hasher.hash(s) % tableSize;
        return index < 0 ? - index : index;
    }
	

	/**
    * Takes a string and removes it from the hash table, if it
    * appears in the hash table.  If it doesn't, this method has no effect.
    *
    * @param s String to remove
    */
	public void remove(String s) {
  	    int index = calculateIndex(s);
	    Node node = elements[index];
	    if (node == null) {
	        return;
        }
	    while (node.getNext() != null) {
	        if (node.getNext().getValue().equals(s)) {
	            node.setNext(node.getNext().getNext());
	            return;
            }
            node = node.getNext();
        }
	}
}
