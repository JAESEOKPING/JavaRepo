package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;
import java.util.List;

public class LibraryManagementSystem {
    
    public static void main(String[] args) {
        // a. ������ ��ü ����
        Library library = new Library("�߾ӵ�����");
        
        // b. ���� ���� �߰�
        addSampleBooks(library);
        
        // c. ������ ���� ���
        System.out.println("=== " + library.getName() + " ���� ===");
        System.out.println("�� ���� ��: " + library.getTotalBooks());
        System.out.println("���� ������ ���� ��: " + library.getAvailableBooksCount());
        System.out.println("����� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
        
        // d. ��� �׽�Ʈ
        testFindBook(library);
        testCheckOut(library);
        testReturn(library);
        
        // e. ���� ������ ���� ��� ���
        displayAvailableBooks(library);
    }
    
    // ���� ���� �߰�
    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
    }
    
    // ���� �˻� �׽�Ʈ
    private static void testFindBook(Library library) {
        System.out.println("=== ���� �˻� �׽�Ʈ ===");
        
        // �������� �˻�
        Book book = library.findBookByTitle("Clean Code");
        if (book != null) {
            System.out.println("���� �˻� ���: " + book);
        }
        
        // ���ڷ� �˻�
        List<Book> books = library.findBooksByAuthor("���ڹ�");
        System.out.println("���� '���ڹ�'�� ����:");
        for (Book b : books) {
            System.out.println("  - " + b);
        }
        System.out.println();
    }
    
    // ���� �׽�Ʈ
    private static void testCheckOut(Library library) {
        System.out.println("=== ���� �׽�Ʈ ===");
        String isbn = "978-89-01-12345-6";
        
        if (library.checkOutBook(isbn)) {
            System.out.println("���� ���� ����: " + isbn);
        } else {
            System.out.println("���� ���� ����: " + isbn);
        }
        
        // ���� �� ���� Ȯ��
        Book book = library.findBookByISBN(isbn);
        if (book != null) {
            System.out.println("���� �� ����: " + book);
        }
        System.out.println();
    }
    
    // �ݳ� �׽�Ʈ
    private static void testReturn(Library library) {
        System.out.println("=== �ݳ� �׽�Ʈ ===");
        String isbn = "978-89-01-12345-6";
        
        if (library.returnBook(isbn)) {
            System.out.println("���� �ݳ� ����: " + isbn);
        } else {
            System.out.println("���� �ݳ� ����: " + isbn);
        }
        
        // �ݳ� �� ���� Ȯ��
        Book book = library.findBookByISBN(isbn);
        if (book != null) {
            System.out.println("�ݳ� �� ����: " + book);
        }
        System.out.println();
    }
    
    // ���� ������ ���� ��� ���
    private static void displayAvailableBooks(Library library) {
        System.out.println("=== ���� ������ ���� ��� ===");
        List<Book> availableBooks = library.getAvailableBooks();
        
        for (int i = 0; i < availableBooks.size(); i++) {
            System.out.println((i + 1) + ". " + availableBooks.get(i));
        }
        
        System.out.println("\n�� " + availableBooks.size() + "���� ������ ���� �����մϴ�.");
    }
}