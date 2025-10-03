package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static Book[] books = new Book[30];
    public static int numberOfBooks = 25;
    public static void main(String[] args) {

        //Gemini generated
        books[0] = new Book(1, "978-0321765723", "The Lord of the Rings: The Fellowship of the Ring", false, "");
        books[1] = new Book(2, "978-0743273565", "The Great Gatsby", false, "");
        books[2] = new Book(3, "978-0061120084", "To Kill a Mockingbird", false, "");
        books[3] = new Book(4, "978-0385537854", "The Girl with the Dragon Tattoo", false, "");
        books[4] = new Book(5, "978-0439023528", "The Hunger Games", false, "");
        books[5] = new Book(6, "978-1984801939", "Where the Crawdads Sing", false, "");
        books[6] = new Book(7, "978-0143124508", "Sapiens: A Brief History of Humankind", false, "");
        books[7] = new Book(8, "978-0743273565", "1984", false, "");
        books[8] = new Book(9, "978-0307593313", "Gone Girl", false, "");
        books[9] = new Book(10, "978-0062316097", "The Alchemist", false, "");
        books[10] = new Book(11, "978-0743273565", "Pride and Prejudice", false, "");
        books[11] = new Book(12, "978-0316769174", "The Catcher in the Rye", false, "");
        books[12] = new Book(13, "978-0060935467", "The Hitchhiker's Guide to the Galaxy", false, "");
        books[13] = new Book(14, "978-0547928227", "The Hobbit", false, "");
        books[14] = new Book(15, "978-0735219106", "Educated: A Memoir", false, "");
        books[15] = new Book(16, "978-0385537854", "A Game of Thrones", false, "");
        books[16] = new Book(17, "978-0743273565", "Moby Dick", false, "");
        books[17] = new Book(18, "978-0590353427", "Harry Potter and the Sorcerer's Stone", false, "");
        books[18] = new Book(19, "978-0345339683", "Dune", false, "");
        books[19] = new Book(20, "978-0062316097", "Little Women", false, "");
        books[20] = new Book(21, "978-0385537854", "Brave New World", false, "");
        books[21] = new Book(22, "978-0743273565", "The Road", false, "");
        books[22] = new Book(23, "978-0439023528", "The Secret History", false, "");
        books[23] = new Book(24, "978-0062316097", "Where'd You Go, Bernadette", false, "");
        books[24] = new Book(25, "978-0307593313", "The Martian", false, "");

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show Checked Out Books");
            System.out.println("3 - Add a New Book");
            System.out.println("4 - Exit");
            System.out.println("Enter you command:");

            int command = in.nextInt();
            in.nextLine();
            switch (command) {
                case 1:
                    ShowAvailableBooks();
                    CheckOutBook(in);
                    break;
                case 2:
                    ShowCheckedOutBooks();
                    CheckInBook(in);
                    break;
                case 3:

                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }
    public static void ShowAvailableBooks(){
        System.out.println("List of available books:");
        for (int i = 0; i < books.length; i++) {
            if(!books[i].isCheckedOut()) {
                System.out.println(books[i]);
            }
        }
    }
    public static void CheckOutBook(Scanner in){
        System.out.println("Do you want to check out any of those books?(yes/no)");
        String ans = in.nextLine();
        if(ans.equalsIgnoreCase("yes")){
            System.out.println("What book do you want to check out?(provide id)");
            int id = in.nextInt();
            in.nextLine();
            if(id <= numberOfBooks||id==0) {
                if (!books[id-1].isCheckedOut()) {
                    System.out.println("Please enter your name: ");
                    String name = in.nextLine();
                    books[id - 1].CheckOut(name);
                    System.out.println("You can pick up your book! Successfully checked out.");
                }
                else {
                    System.out.println("This book is checked out already");
                }
            }else {
                System.out.println("Invalid id");
            }
        }
    }
    public static void ShowCheckedOutBooks(){
        System.out.println("List of checked out books:");
        for (int i = 0; i < books.length; i++) {
            if(books[i].isCheckedOut()) {
                System.out.println(books[i]);
            }
        }
    }
    public static void CheckInBook(Scanner in){
        System.out.println("Do you want to check in any of those books?(yes/no)");
        String ans = in.nextLine();
        if(ans.equalsIgnoreCase("yes")){
            System.out.println("What book do you want to check in?(provide id)");
            int id = in.nextInt();
            in.nextLine();
            if(id <= numberOfBooks&&id!=0) {
                if (books[id-1].isCheckedOut()) {
                    books[id - 1].CheckIn();
                    System.out.println("Thank you! Successfully checked in.");
                }
                else {
                    System.out.println("This book is not checked out");
                }
            }else {
                System.out.println("Invalid id");
            }
        }
    }
    public static void AddNewBook(Scanner in){
        if(numberOfBooks<books.length){
            System.out.println("Please enter isbn:");
            String isbn = in.nextLine();
            System.out.println("Please enter title:");
            String title = in.nextLine();
            books[numberOfBooks] = new Book(numberOfBooks+1, isbn, title, false, "");
            System.out.println(title + " - has been added to the library");
        }
        else {
            System.out.println("Library is full");
        }
    }

}
