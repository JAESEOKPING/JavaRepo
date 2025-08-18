package mylab.bank.entity;

import mylab.bank.exception.*;

/**
 * ���� ���¸� ǥ���ϴ� Ŭ���� (Account Ŭ���� ���)
 */
public class SavingsAccount extends Account {

    private double interestRate;    // ������

    /**
     * SavingsAccount ������
     * @param accountNumber ���¹�ȣ
     * @param ownerName ���¼����� �̸�
     * @param initialBalance �ʱ� �ܾ�
     * @param interestRate ������
     */
    public SavingsAccount(int accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    /**
     * �Ա� �޼ҵ�
     * @param amount �Ա��� �ݾ�
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("[������� %d] %.0f�� �Ա� �Ϸ�. ���� �ܾ�: %.0f��\n", 
                            accountNumber, amount, balance);
        } else {
            System.out.println("�Ա� �ݾ��� 0���� Ŀ�� �մϴ�.");
        }
    }

    /**
     * ��� �޼ҵ�
     * @param amount ����� �ݾ�
     * @throws InsufficientBalanceException �ܾ� ������
     */
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("��� �ݾ��� 0���� Ŀ�� �մϴ�.");
            return;
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }

        balance -= amount;
        System.out.printf("[������� %d] %.0f�� ��� �Ϸ�. ���� �ܾ�: %.0f��\n", 
                        accountNumber, amount, balance);
    }

    /**
     * ���� ���� �޼ҵ�
     */
    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.printf("[������� %d] ���� %.0f�� ����. ���� �ܾ�: %.0f�� (������: %.1f%%)\n", 
                        accountNumber, interest, balance, interestRate);
    }

    // Getter �޼ҵ�
    public double getInterestRate() {
        return interestRate;
    }

    // Setter �޼ҵ�
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return String.format("[�������] ���¹�ȣ: %d, ������: %s, �ܾ�: %.0f��, ������: %.1f%%", 
                           accountNumber, ownerName, balance, interestRate);
    }
}
