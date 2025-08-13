package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;
import java.util.List;

public class LibraryManagementSystem {
    
    public static void main(String[] args) {
        // a. 도서관 객체 생성
        Library library = new Library("중앙도서관");
        
        // b. 샘플 도서 추가
        addSampleBooks(library);
        
        // c. 도서관 정보 출력
        System.out.println("=== " + library.getName() + " 정보 ===");
        System.out.println("총 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능한 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출된 도서 수: " + library.getBorrowedBooksCount());
        System.out.println();
        
        // d. 기능 테스트
        testFindBook(library);
        testCheckOut(library);
        testReturn(library);
        
        // e. 대출 가능한 도서 목록 출력
        displayAvailableBooks(library);
    }
    
    // 샘플 도서 추가
    private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
    }
    
    // 도서 검색 테스트
    private static void testFindBook(Library library) {
        System.out.println("=== 도서 검색 테스트 ===");
        
        // 제목으로 검색
        Book book = library.findBookByTitle("Clean Code");
        if (book != null) {
            System.out.println("제목 검색 결과: " + book);
        }
        
        // 저자로 검색
        List<Book> books = library.findBooksByAuthor("김자바");
        System.out.println("저자 '김자바'의 도서:");
        for (Book b : books) {
            System.out.println("  - " + b);
        }
        System.out.println();
    }
    
    // 대출 테스트
    private static void testCheckOut(Library library) {
        System.out.println("=== 대출 테스트 ===");
        String isbn = "978-89-01-12345-6";
        
        if (library.checkOutBook(isbn)) {
            System.out.println("도서 대출 성공: " + isbn);
        } else {
            System.out.println("도서 대출 실패: " + isbn);
        }
        
        // 대출 후 상태 확인
        Book book = library.findBookByISBN(isbn);
        if (book != null) {
            System.out.println("대출 후 상태: " + book);
        }
        System.out.println();
    }
    
    // 반납 테스트
    private static void testReturn(Library library) {
        System.out.println("=== 반납 테스트 ===");
        String isbn = "978-89-01-12345-6";
        
        if (library.returnBook(isbn)) {
            System.out.println("도서 반납 성공: " + isbn);
        } else {
            System.out.println("도서 반납 실패: " + isbn);
        }
        
        // 반납 후 상태 확인
        Book book = library.findBookByISBN(isbn);
        if (book != null) {
            System.out.println("반납 후 상태: " + book);
        }
        System.out.println();
    }
    
    // 대출 가능한 도서 목록 출력
    private static void displayAvailableBooks(Library library) {
        System.out.println("=== 대출 가능한 도서 목록 ===");
        List<Book> availableBooks = library.getAvailableBooks();
        
        for (int i = 0; i < availableBooks.size(); i++) {
            System.out.println((i + 1) + ". " + availableBooks.get(i));
        }
        
        System.out.println("\n총 " + availableBooks.size() + "권의 도서가 대출 가능합니다.");
    }
}