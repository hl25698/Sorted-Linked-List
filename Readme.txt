CSCI 2720 - Assignment 1
Name: Hannah LeEmail: hl25698@uga.edu

    Compiling:
        1. Change directories to ~/csci2720/Le-assignment1
            cd ~/csci2720/Le-assignment1
        2. Compile files
            javac -d bin src/*.java
    Running:
        java -cp bin LinkedListDriver input.txt

    Pseudocode for merge function:
        1. Create a new SortedLinkedList to store the new list after merging.
        2. Initialize two pointers: firstCurr pointing to the head of the first list and secondCurr pointing to the head of the second list.
        3. While both firstCurr and secondCurr are not null:
            If the item firstCurr is pointing to is less than secondCurr, insert the item of firstCurr into the new mergedList and move firstCurr to teh next node. If it is greater than, then insert secondCurr.info into the new mergedList and move secondCurr to the next node. If both values are equal, then insert only firstCurr.info into mergedList, and move both pointers to the next nodes.
        4. Insert the remaining nodes into mergedList after all items have been merged and firstCurr or secondCurr is still not null.
        5. Update the head of the original list to mergedList.head and print mergedList.
        Time complexity: O((n + m)^) with n being the number of nodes in the first list and m being the number of nodes in the second list. Within the merging loop, it runs O(n + m) times, because it processes each element once. The while loop for inserting the remaining items in firstCurr is O(n) and the while loop for secondCurr remaining items is O(m). The insertItem function traverses the list which is O(n + m) for every inserition. Since there are n + m insertions, the inserition operation is O((n+m)^2). Setting head = mergedList.head is O(1). The print statement prints the entire merged list which is O(n + m). The overall time complexity for mergeLists is O((n+m)^2).

    Pseudocode for intersection function:
        1. Create a new SortedLinkedList called newList to store the intersection of the two lists.
        2. Set first to point to the head of the first list and second to point to the head of the second list
        3. While both first and second are not null:
            If first.info is greater than second.info, move second to the next node. If both values are equal, it means a common item has been found so insert first.info into newList and move first and second to the next node.
        4. Set current to the head of the newList. While current is not null:
            Print current.info and move current to the next node.
        Time complexity: O(m+n)
            The while loop runs if both first and second are not null, meaning that each pointer traverses the entire list. If the first list has n elements and the second list has m elements, each list is traversed n + m times.
