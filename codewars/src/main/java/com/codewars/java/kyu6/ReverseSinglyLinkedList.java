package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Implement a function reverse_list which takes a singly-linked list of nodes and returns a matching list in the reverse order.
 *
 * Assume the presence of a class Node, which exposes the property value/Value and next/Next. next must either be set
 * to the next Node in the list, or to None (or null) to indicate the end of the list.
 *
 * To assist in writing tests, a function make_linked_list (Node.asLinkedList() in Java) has also been defined,
 * which converts a python list to a linked list of Node.
 *
 * The final tests will use a very long list. Be aware that a recursive solution will run out of stack.
 */
public class ReverseSinglyLinkedList {

    public static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node previous = null;
        while (node.next != null) {
            Node next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
        node.next = previous;
        return node;
    }

    @Test
    public void testSomething() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;

        Node newHead = reverse(node1);

        assertEquals(node3, newHead);
        assertEquals(node2, node3.next);
        assertEquals(node1, node2.next);
        assertEquals(null, node1.next);
    }

    public static class Node {

        public final Integer value;
        public Node next;

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", value=" + value +
                    '}';
        }
    }


}
