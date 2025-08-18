package mylab.bank.exception;

//출금 한도를 초과할 때 발생하는 예외 클래스

public class WithdrawalLimitExceededException extends InsufficientBalanceException {

    private double withdrawalLimit;

    public WithdrawalLimitExceededException() {
        super("출금 한도를 초과했습니다.");
    }

    public WithdrawalLimitExceededException(String message) {
        super(message);
    }

    public WithdrawalLimitExceededException(double withdrawalLimit, double requestedAmount) {
        super("출금 한도 초과: 한도 " + withdrawalLimit + "원, 요청 금액 " + requestedAmount + "원");
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }
}
