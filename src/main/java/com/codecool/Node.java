package com.codecool;

class Node {
    private int hashValue;
    private String value;
    private Node next;

    Node(int hashValue, String value) {
        this.hashValue = hashValue;
        this.value = value;
    }

    public int getHashValue() {
        return hashValue;
    }

    public String getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
