package mylab.bank.exception;

// ���¸� ã�� �� ���� �� �߻��ϴ� ���� Ŭ����

public class AccountNotFoundException extends Exception {

    public AccountNotFoundException() {
        super("���¸� ã�� �� �����ϴ�.");
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String accountNumber, String message) {
        super("���¹�ȣ " + accountNumber + ": " + message);
    }
}
