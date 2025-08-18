package mylab.bank.entity;

import mylab.bank.exception.*;

/**
 * ��� ������ �⺻�� �Ǵ� �߻� Ŭ����
 */
public abstract class Account {

    protected int accountNumber;        // ���¹�ȣ
    protected String ownerName;         // ���¼����� �̸�
    protected double balance;           // ���� �ܾ�

    /**
     * Account ������
     * @param accountNumber ���¹�ȣ
     * @param ownerName ���¼����� �̸�
     * @param initialBalance �ʱ� �ܾ�
     */
    public Account(int accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    /**
     * �Ա� �޼ҵ� (�߻� �޼ҵ�)
     * @param amount �Ա��� �ݾ�
     */
    public abstract void deposit(double amount);

    /**
     * ��� �޼ҵ� (�߻� �޼ҵ�)
     * @param amount ����� �ݾ�
     * @throws InsufficientBalanceException �ܾ� ������
     */
    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    // Getter �޼ҵ��
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter �޼ҵ��
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return String.format("���¹�ȣ: %d, ������: %s, �ܾ�: %.0f��", 
                           accountNumber, ownerName, balance);
    }
}
