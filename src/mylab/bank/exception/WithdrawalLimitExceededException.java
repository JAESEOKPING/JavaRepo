package mylab.bank.exception;

//��� �ѵ��� �ʰ��� �� �߻��ϴ� ���� Ŭ����

public class WithdrawalLimitExceededException extends InsufficientBalanceException {

    private double withdrawalLimit;

    public WithdrawalLimitExceededException() {
        super("��� �ѵ��� �ʰ��߽��ϴ�.");
    }

    public WithdrawalLimitExceededException(String message) {
        super(message);
    }

    public WithdrawalLimitExceededException(double withdrawalLimit, double requestedAmount) {
        super("��� �ѵ� �ʰ�: �ѵ� " + withdrawalLimit + "��, ��û �ݾ� " + requestedAmount + "��");
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }
}
