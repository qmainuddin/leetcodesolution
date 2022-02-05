package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeKSortedList {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode() {}
        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode[] test1 = getTest1();
        printListNodes(test1);
        printList(merge(test1));
    }

    public static ListNode merge(ListNode[] listNodes) {
        Arrays.sort(listNodes, Comparator.comparing(a -> a.value));
        printListNodes(listNodes);
        ListNode root = listNodes[0];

        for (int i = 1; i<listNodes.length; i++) {
            ListNode prevNode = root;
            ListNode currentNode = root.next;
            ListNode secondaryNode = listNodes[i];
            while (secondaryNode != null) {
                if (secondaryNode.value < currentNode.value) {
                    ListNode temp = secondaryNode.next;
                    prevNode.next = secondaryNode;
                    secondaryNode.next = currentNode;
                    prevNode = prevNode.next;
                    secondaryNode = temp;
                } else {
                    prevNode = currentNode;
                    currentNode = currentNode.next;
                }
                if (currentNode == null) {
                    currentNode = secondaryNode;
                    prevNode.next = currentNode;
                    break;
                }
            }
        }

        return root;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.printf(node.value + ", ");
            node = node.next;
        }
    }

    public static void printListNodes (ListNode[] listNodes) {
        System.out.printf("[");
        for (int i = 0; i< listNodes.length; i++) {
            ListNode node = listNodes[i];
            System.out.printf("{");
            while (node != null) {
                System.out.printf(" " + node.value);
                if (node.next != null) {
                    System.out.printf(",");
                }
                node = node.next;
            }
            System.out.printf("}");
            if (i != listNodes.length - 1) {
                System.out.printf(",");
            }
        }
        System.out.println("]");
    }

    public static ListNode[] getTest1 () {
        return new ListNode[] {getListNode(new int[] {1, 4, 5}), getListNode(new int[] {2, 6}), getListNode(new int[] {1, 3, 4})};
    }

    public static ListNode getListNode(int[] a) {
        ListNode root = new ListNode(a[0]);
        ListNode currentNode = root;
        for (int i = 1; i< a.length; i++) {
            ListNode temp = new ListNode(a[i]);
            currentNode.next = temp;
            currentNode = temp;
        }
        return root;
    }
}
