package com.example.bibblan.Loans;

public class LoanDTO {

    private Integer userId;
    private Integer bookId;
    private String bookTitle;

    // Default constructor
    public LoanDTO() {
    }

    // Constructor
    public LoanDTO(Integer userId, Integer bookId, String bookTitle) {
        this.userId = userId;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}

