package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    public static void main(String[] args) {

        Book[] books = new Book[5];
        books[0] = new Book(1, "1111", "Pride and Prejudice");
        books[1] = new Book(2, "2222", "To kill the mocking bird");
        books[2] = new Book(3, "3333", "The catcher in the ray");
        books[3] = new Book(4, "4444", "The great gatsby");
        books[4] = new Book(5, "5555", "Men's searching for meaning");


        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("Welcome to Neighborhood Library. Please choose an option to continue :) ");
            System.out.println("1 To Show Available Books");
            System.out.println("2 To Show Checked Out Books");
            System.out.println("3 To Exit.......Byeeeeee");

            int response = scanner.nextInt();
            scanner.nextLine();

            switch (response) {

                case 1:
                    showAvailableBooks(books, scanner);
                    break;
                case 2:
                    showCheckedOutBooks(books, scanner);
                    break;
                case 3:
                    System.out.println("Exiting.............");
                    System.exit(0);
                default:
                    System.out.println("Error. Please enter a number from 1 and 3.");
                    break;

            }
        }
    }
    // Method to show available books
    public static void showAvailableBooks(Book[] books, Scanner scanner) {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
            }
        }
        System.out.println("Select a book to check out (enter ID) or type 'exit' to go back to home screen:");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("exit")) {
            return;
        }
        int selectedId = Integer.parseInt(input);
        for (Book book : books) {
            if (book.getId() == selectedId) {
                System.out.println("Enter your name:");
                String name = scanner.nextLine();
                book.checkOut(name);
                break;
            }
        }
    }


    public static void showCheckedOutBooks(Book[] books, Scanner scanner) {
        System.out.println("Checked Out Books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle()
                        + ", Checked Out To: " + book.getCheckedOutTo());
            }
        }
        System.out.println("C - Check In a book");
        System.out.println("X - Go back to home screen");
        String input = scanner.nextLine();

        switch (input.toUpperCase()) {
            case "C":
                checkInBook(books, scanner);
                break;
            case "X":
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void checkInBook(Book[] books, Scanner scanner) {
        System.out.println("Enter the ID of the book you want to check in:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (Book book : books) {
            if (book.getId() == id) {
                book.checkIn();
                return;
            }
        }

        System.out.println("Book with ID " + id + " not found.");
    }



    }






