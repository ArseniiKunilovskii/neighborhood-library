package com.pluralsight;

public class Book {
    private int id = 0;
    private String isbn = "";
    private String title = "";
    private boolean isCheckedOut = false;
    private String checkedOutTo = "";

    public Book() {
    }
    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
    public void CheckOut(String name){
        if(!isCheckedOut) {
            setCheckedOut(true);
            setCheckedOutTo(name);
        }else {
            System.out.println("Book has been checked out");
        }
    }
    public void CheckIn(){
        if(isCheckedOut) {
            setCheckedOut(false);
            setCheckedOutTo("");
        }
        else {
            System.out.println("This book hasn't been checked out");
        }
    }

    @Override
    public String toString() {
        return "Book " +
                "id = " + id +
                " |isbn = " + isbn  +
                "| title = " + title;
    }
}
