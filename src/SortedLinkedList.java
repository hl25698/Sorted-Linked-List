public class SortedLinkedList {
    private NodeType head;

    public SortedLinkedList() {
        this.head = null;
    }

    public int getLength() {
        int length = 0;
        NodeType current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void insertItem(ItemType item) {
        NodeType newNode = new NodeType(item);
        // Special case: Empty list or inserting at beginning
        if (head == null || head.info.compareTo(item) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            NodeType current = head;
            //Special case: Duplicate item at head
            if (current.info.compareTo(item) == 0) {
                System.out.print("\nItem already exists.");
                return;
            }
            while (current.next != null && current.next.info.compareTo(item) < 0) {
                current = current.next;
            }
            //Special case: Duplicate item
            if (current.next != null && current.next.info.compareTo(item) == 0) {
                System.out.print("\nItem already exists.");
                return;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void deleteItem(ItemType item) {
        //Special case: Empty list
        if (head == null) {
            System.out.print("You cannot delete from an empty list.");
            return;
        }
        //Special case: Deleting first item
        if (head.info.compareTo(item) == 0) {
            head = head.next;
            return;
        }

        NodeType current = head;
        while (current.next != null && current.next.info.compareTo(item) != 0) {
            current = current.next;
        }
        //item not found
        if (current.next == null) {
            System.out.print("\nThe item is not present in the list.");
        } else {
            //deleting the item
            current.next = current.next.next;
        }
    }

    public int searchItem(ItemType item) {
        int index = 1;
        NodeType current = head;
        while (current != null) {
            if (current.info.compareTo(item) == 0) {
                return index;
            } else {
                index++;
                current = current.next;
            }
        }
        return -1;
    }

    public void printList() {
        if (head == null) {
            System.out.print("\nThe list is empty.");
            return;
        }
        NodeType current = head;
        System.out.print("The list is: ");
        while (current != null) {
            System.out.print(current.info.getValue() + " ");
            current = current.next;
        }
    }

    public void printValues() {
        /*        if (head == null) {
            System.out.print("\nThe list is empty.");
            return;
            }*/
        NodeType current = head;
        while (current != null) {
            System.out.print(current.info.getValue() + " ");
            current = current.next;
        }
    }

    public void mergeList(SortedLinkedList secondList) {
        SortedLinkedList mergedList = new SortedLinkedList();
        NodeType firstCurr = head;
        NodeType secondCurr = secondList.head;

        while (firstCurr != null && secondCurr != null) {
            // inserting item from first list
            if (firstCurr.info.compareTo(secondCurr.info) < 0) {
                mergedList.insertItem(firstCurr.info);
                firstCurr = firstCurr.next;
                // inserting item from second list
            } else if (firstCurr.info.compareTo(secondCurr.info) > 0) {
                mergedList.insertItem(secondCurr.info);
                secondCurr = secondCurr.next;
            } else {
                // duplicates
                mergedList.insertItem(firstCurr.info);
                firstCurr = firstCurr.next;
                secondCurr = secondCurr.next;
            }
        }
        // inserting remaining items from first list
        while (firstCurr != null) {
            mergedList.insertItem(firstCurr.info);
            firstCurr = firstCurr.next;
        }
        //inserting remaining items from second list
        while (secondCurr != null) {
            mergedList.insertItem(secondCurr.info);
            secondCurr = secondCurr.next;
        }
        head = mergedList.head;
        mergedList.printValues();
    }

    public void deleteAlternates() {
        if (head == null) {
            System.out.print("\nThe list is empty");
            return;
        }
        NodeType current = head;
        while (current != null && current.next != null) {
            current.next = current.next.next;
            current = current.next;
        }
    }

    public void intersection(SortedLinkedList secondList) {
        SortedLinkedList newList = new SortedLinkedList();
        NodeType first = head;
        NodeType second = secondList.head;

        while (first != null && second != null) {
            if (first.info.compareTo(second.info) < 0) {
                first = first.next;
            } else if (first.info.compareTo(second.info) > 0) {
                second = second.next;
            } else {
                //common element found
                newList.insertItem(first.info);
                first = first.next;
                second = second.next;
            }
        }
        //printing list
        NodeType current = newList.head;
        while (current != null) {
            System.out.print(current.info.getValue() + " ");
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
