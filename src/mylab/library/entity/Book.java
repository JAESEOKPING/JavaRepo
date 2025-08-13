package mylab.library.entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;
    
    // �⺻ ������
    public Book() {
        this.isAvailable = true;
    }
    
    // �Ű����� �ִ� ������
    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }
    
    // Getter �޼����
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
    
    // Setter �޼����
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
    
    // ���� ���� �޼���
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    // ���� �ݳ� �޼���
    public void returnBook() {
        isAvailable = true;
    }
    
    @Override
    public String toString() {
        return String.format("����: %s, ����: %s, ISBN: %s, ���ǿ���: %d, ���Ⱑ��: %s",
                title, author, isbn, publishYear, isAvailable ? "��" : "�ƴϿ�");
    }
}
