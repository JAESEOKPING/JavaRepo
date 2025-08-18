package mylab.bank.entity;

import java.util.ArrayList;
import mylab.bank.exception.*;

/**
 * ���� �ý����� �ֿ� ���� Ŭ����
 */
public class Bank {

    private ArrayList<Account> accounts;        // ���� ���
    private int nextAccountNumber;              // ���� ���¹�ȣ

    /**
     * Bank ������ - ArrayList ��ü����, nextAccountNumber = 1000���� �ʱ�ȭ
     */
    public Bank() {
        accounts = new ArrayList<Account>();
        nextAccountNumber = 1000;
        System.out.println("���� �ý����� �ʱ�ȭ�Ǿ����ϴ�.");
    }

    /**
     * ���� ���� ����
     * @param ownerName ���¼����� �̸�
     * @param initialBalance �ʱ� �ܾ�
     * @param interestRate ������
     * @return ������ ���¹�ȣ
     */
    public int createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        int accountNumber = nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.printf("���� ���°� �����Ǿ����ϴ�. ���¹�ȣ: %d, ������: %s\n", 
                        accountNumber, ownerName);
        return accountNumber;
    }

    /**
     * üŷ ���� ����
     * @param ownerName ���¼����� �̸�
     * @param initialBalance �ʱ� �ܾ�
     * @param withdrawalLimit ��� �ѵ�
     * @return ������ ���¹�ȣ
     */
    public int createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        int accountNumber = nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.printf("üŷ ���°� �����Ǿ����ϴ�. ���¹�ȣ: %d, ������: %s\n", 
                        accountNumber, ownerName);
        return accountNumber;
    }

    /**
     * ���� ��ȸ
     * @param accountNumber ���¹�ȣ
     * @return ���� ��ü
     * @throws AccountNotFoundException ���¸� ã�� �� ���� ��
     */
    public Account findAccount(int accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException(String.valueOf(accountNumber), "�ش� ���¹�ȣ�� �������� �ʽ��ϴ�.");
    }

    /**
     * �Ա�
     * @param accountNumber ���¹�ȣ
     * @param amount �Ա��� �ݾ�
     * @throws AccountNotFoundException ���¸� ã�� �� ���� ��
     */
    public void deposit(int accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    /**
     * ���
     * @param accountNumber ���¹�ȣ
     * @param amount ����� �ݾ�
     * @throws AccountNotFoundException ���¸� ã�� �� ���� ��
     * @throws InsufficientBalanceException �ܾ� ������
     */
    public void withdraw(int accountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    /**
     * ���� ��ü
     * @param fromAccountNumber ��� ���¹�ȣ
     * @param toAccountNumber �Ա� ���¹�ȣ
     * @param amount ��ü�� �ݾ�
     * @throws AccountNotFoundException ���¸� ã�� �� ���� ��
     * @throws InsufficientBalanceException �ܾ� ������
     */
    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {

        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        // ��� (���� �߻� ����)
        fromAccount.withdraw(amount);

        // �Ա� (����� ������ ��쿡�� ����)
        toAccount.deposit(amount);

        System.out.printf("���� ��ü �Ϸ�: %d �� %d, %.0f��\n", 
                        fromAccountNumber, toAccountNumber, amount);
    }

    /**
     * ���� ���� ���� ����
     * @param accountNumber ���¹�ȣ
     * @throws AccountNotFoundException ���¸� ã�� �� ���� ��
     */
    public void applyInterest(int accountNumber) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        if (account instanceof SavingsAccount) {
            ((SavingsAccount) account).applyInterest();
        } else {
            System.out.println("���� ���°� �ƴմϴ�. ���ڸ� ������ �� �����ϴ�.");
        }
    }

    /**
     * ��� ���� ���� ���
     */
    public void printAllAccounts() {
        System.out.println("\n=== ��ü ���� ���� ===");
        if (accounts.isEmpty()) {
            System.out.println("��ϵ� ���°� �����ϴ�.");
        } else {
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
        System.out.println("==================");
    }

    /**
     * �� ���� �� ��ȯ
     * @return ���� ��
     */
    public int getAccountCount() {
        return accounts.size();
    }

    /**
     * ���� ���¹�ȣ ��ȯ
     * @return ���� ���¹�ȣ
     */
    public int getNextAccountNumber() {
        return nextAccountNumber;
    }
}
