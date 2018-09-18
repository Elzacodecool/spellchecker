package com.codecool;

public interface StringHasher {
	/** 
   * Returns an integer that is a hash value for the given string s.
   * The integer can potentially be any value in the range of Java ints
   * (i.e. Integer.MIN_VALUE .. Integer.MAX_VALUE).
   *
   * @param s String to hash
   * @return hash code for the input string
   */
	public int hash(String s);
}
