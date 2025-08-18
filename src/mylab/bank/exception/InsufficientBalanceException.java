
package mylab.bank.exception;

// 잔액이 부족할 때 발생하는 예외 클래스

public class InsufficientBalanceException extends Exception {

    private double currentBalance;
    private double requestedAmount;

    public InsufficientBalanceException() {
        super("잔액이 부족합니다.");
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }

    public InsufficientBalanceException(double currentBalance, double requestedAmount) {
        super("잔액 부족: 현재 잔액 " + currentBalance + "원, 요청 금액 " + requestedAmount + "원");
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
