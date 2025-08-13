package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;
    
    // ������
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    // ���� �߰�
    public void addBook(Book book) {
        books.add(book);
    }
    
    // �������� ���� �˻�
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    // ���ڷ� ���� �˻�
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
    
    // ISBN���� ���� �˻�
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    
    // ISBN���� ���� ����
    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            return book.checkOut();
        }
        return false;
    }
    
    // ISBN���� ���� �ݳ�
    public boolean returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            book.returnBook();
            return true;
        }
        return false;
    }
    
    // ���� ������ ���� ��� ��ȯ
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    
    // ��ü ���� ��� ��ȯ
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
    
    // ��ü ���� ��
    public int getTotalBooks() {
        return books.size();
    }
    
    // ���� ������ ���� ��
    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }
    
    // ����� ���� ��
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
    
    // ������ �̸� getter
    public String getName() {
        return name;
    }
}
