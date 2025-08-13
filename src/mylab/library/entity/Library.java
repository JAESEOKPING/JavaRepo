package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;
    
    // 생성자
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    // 도서 추가
    public void addBook(Book book) {
        books.add(book);
    }
    
    // 제목으로 도서 검색
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    // 저자로 도서 검색
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
    
    // ISBN으로 도서 검색
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    
    // ISBN으로 도서 대출
    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            return book.checkOut();
        }
        return false;
    }
    
    // ISBN으로 도서 반납
    public boolean returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            book.returnBook();
            return true;
        }
        return false;
    }
    
    // 대출 가능한 도서 목록 반환
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    
    // 전체 도서 목록 반환
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
    
    // 전체 도서 수
    public int getTotalBooks() {
        return books.size();
    }
    
    // 대출 가능한 도서 수
    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }
    
    // 대출된 도서 수
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
    
    // 도서관 이름 getter
    public String getName() {
        return name;
    }
}
