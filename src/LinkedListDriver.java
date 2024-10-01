import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        // ensures file name is given for the command-line argument
        if (args.length != 1) {
            System.out.println("File name needed");
            return;
        }
        String fileName = args[0];
        SortedLinkedList list = new SortedLinkedList();
        //read integers from file and adding to linked list
        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                ItemType item = new ItemType();
                item.initialize(num);
                list.insertItem(item);
            }
            fileScanner.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found.");
            return;
        }
        //scanner to read user inputs
        Scanner input = new Scanner(System.in);
        char command;
        int num, length, value;
        do {
            //command options
            System.out.print("\nCommands:\n" + "(i) - Insert value\n(d) - Delete value\n" +
                               "(s) - Search value\n(a) - Delete alternate nodes\n" +
                               "(m) - Merge lists\n(t) - Find intersection\n" +
                               "(p) - Print list\n(l) - Print length\n(q) - Quit program");
            System.out.println();
            //reading user command
            System.out.print("Enter a command: ");
            String inputCmd = input.next();
            if (inputCmd.length() == 1) {
                command = inputCmd.charAt(0);
            } else {
                command = ' ';
            }

            while (command != 'i' && command != 'd' && command != 's' && command != 'a' &&
                   command != 'm' && command != 't' && command != 'p' && command != 'l' &&
                   command != 'q') {
                System.out.print("Invalid command, try again: ");
                command = input.next().charAt(0);
            }

            switch (command) {
            case 'i':
                System.out.print("Enter a number to insert: ");
                num = input.nextInt();
                System.out.print("Original list : ");
                list.printValues();
                ItemType item = new ItemType();
                item.initialize(num);
                list.insertItem(item);
                System.out.print("\nNew list : ");
                list.printValues();
                break;
            case 'd':
                System.out.print("Enter a number to delete: ");
                num = input.nextInt();
                item = new ItemType();
                item.initialize(num);
                if (list.isEmpty()) {
                    list.deleteItem(item);
                } else {
                    System.out.print("Original list : ");
                    list.printValues();
                    list.deleteItem(item);
                    System.out.print("\nNew list : ");
                    list.printValues();
                }
                break;
            case 's':
                System.out.print("Enter a number to search: ");
                num = input.nextInt();
                System.out.print("Original list : ");
                list.printValues();
                if (list.isEmpty()) {
                    System.out.print("\nThe list is empty.");
                } else {
                    item = new ItemType();
                    item.initialize(num);
                    int index = list.searchItem(item);
                    if (index == -1) {
                        System.out.print("\nThe item is not present in the list.");
                    } else {
                        System.out.print("\nThe item is present at index " + index);
                    }
                }
                break;
            case 'p':
                list.printList();
                break;
            case 'l':
                System.out.print("The length of the list is: " + list.getLength());
                break;
            case 'a':
                System.out.print("Original list : ");
                list.printValues();
                list.deleteAlternates();
                System.out.print("\nNew list : ");
                list.printValues();
                break;
            case 'm':
                SortedLinkedList merged = new SortedLinkedList();
                System.out.print("Enter the length of the new list: ");
                length = input.nextInt();
                System.out.print("Enter the numbers: ");
                for (int i = 0; i < length; i++) {
                    value = input.nextInt();
                    item = new ItemType();
                    item.initialize(value);
                    merged.insertItem(item);
                }
                System.out.print("list 1: ");
                list.printValues();
                System.out.print("\nlist 2: ");
                merged.printValues();
                System.out.print("\nMerged list: ");
                list.mergeList(merged);
                break;
            case 't':
                SortedLinkedList newList = new SortedLinkedList();
                System.out.print("Enter the length of the new list: ");
                length = input.nextInt();
                System.out.print("Enter the numbers: ");
                for (int i = 0; i < length; i++) {
                    value = input.nextInt();
                    item = new ItemType();
                    item.initialize(value);
                    newList.insertItem(item);
                }
                System.out.print("list 1: ");
                list.printValues();
                System.out.print("\nlist 2: ");
                newList.printValues();
                System.out.print("\nIntersection of lists: ");
                list.intersection(newList);
                break;
            case 'q':
                System.out.println("Exiting program..");
                break;
            default:
                System.out.println("Invalid command");
            }
        } while (command != 'q');
        input.close();
    }
}
