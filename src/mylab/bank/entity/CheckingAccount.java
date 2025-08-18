package mylab.bank.entity;

import mylab.bank.exception.*;

/**
 * üŷ ���¸� ǥ���ϴ� Ŭ���� (Account Ŭ���� ���)
 */
public class CheckingAccount extends Account {

    private double withdrawalLimit;     // ��� �ѵ�

    /**
     * CheckingAccount ������
     * @param accountNumber ���¹�ȣ
     * @param ownerName ���¼����� �̸�
     * @param initialBalance �ʱ� �ܾ�
     * @param withdrawalLimit ��� �ѵ�
     */
    public CheckingAccount(int accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    /**
     * �Ա� �޼ҵ�
     * @param amount �Ա��� �ݾ�
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("[üŷ���� %d] %.0f�� �Ա� �Ϸ�. ���� �ܾ�: %.0f��\n", 
                            accountNumber, amount, balance);
        } else {
            System.out.println("�Ա� �ݾ��� 0���� Ŀ�� �մϴ�.");
        }
    }

    /**
     * ��� �޼ҵ�
     * @param amount ����� �ݾ�
     * @throws InsufficientBalanceException �ܾ� ������
     * @throws WithdrawalLimitExceededException ��� �ѵ� �ʰ���
     */
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("��� �ݾ��� 0���� Ŀ�� �մϴ�.");
            return;
        }

        // ��� �ѵ� �˻�
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(withdrawalLimit, amount);
        }

        // �ܾ� �˻�
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }

        balance -= amount;
        System.out.printf("[üŷ���� %d] %.0f�� ��� �Ϸ�. ���� �ܾ�: %.0f��\n", 
                        accountNumber, amount, balance);
    }

    // Getter �޼ҵ�
    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    // Setter �޼ҵ�
    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public String toString() {
        return String.format("[üŷ����] ���¹�ȣ: %d, ������: %s, �ܾ�: %.0f��, ����ѵ�: %.0f��", 
                           accountNumber, ownerName, balance, withdrawalLimit);
    }
}
