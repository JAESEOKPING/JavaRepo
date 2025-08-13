package mylab.library.entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;
    
    // 기본 생성자
    public Book() {
        this.isAvailable = true;
    }
    
    // 매개변수 있는 생성자
    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }
    
    // Getter 메서드들
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public int getPublishYear() {
        return publishYear;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setter 메서드들
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    // 도서 대출 메서드
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    // 도서 반납 메서드
    public void returnBook() {
        isAvailable = true;
    }
    
    @Override
    public String toString() {
        return String.format("제목: %s, 저자: %s, ISBN: %s, 출판연도: %d, 대출가능: %s",
                title, author, isbn, publishYear, isAvailable ? "예" : "아니오");
    }
}
