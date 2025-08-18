
package mylab.bank.exception;

// �ܾ��� ������ �� �߻��ϴ� ���� Ŭ����

public class InsufficientBalanceException extends Exception {

    private double currentBalance;
    private double requestedAmount;

    public InsufficientBalanceException() {
        super("�ܾ��� �����մϴ�.");
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }

    public InsufficientBalanceException(double currentBalance, double requestedAmount) {
        super("�ܾ� ����: ���� �ܾ� " + currentBalance + "��, ��û �ݾ� " + requestedAmount + "��");
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }
}
