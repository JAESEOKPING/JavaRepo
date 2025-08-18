package mylab.bank.exception;

// 계좌를 찾을 수 없을 때 발생하는 예외 클래스

public class AccountNotFoundException extends Exception {

    public AccountNotFoundException() {
        super("계좌를 찾을 수 없습니다.");
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String accountNumber, String message) {
        super("계좌번호 " + accountNumber + ": " + message);
    }
}
