package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

/**
 * ���� �ý����� ����� �׽�Ʈ�ϴ� Ŭ����
 */
public class BankDemo {

    public static void main(String[] args) {

        // ���� �ý��� �ʱ�ȭ
        Bank bank = new Bank();

        System.out.println("\n=== ���� �ý��� �׽�Ʈ ���� ===\n");

        try {
            // 1. ���� ���� �׽�Ʈ
            System.out.println("1. ���� ���� �׽�Ʈ");
            System.out.println("==================");

            int savingsAccount1 = bank.createSavingsAccount("��ö��", 100000, 3.0);
            int savingsAccount2 = bank.createSavingsAccount("�̿���", 200000, 2.5);
            int checkingAccount1 = bank.createCheckingAccount("�ڹμ�", 150000, 50000);
            int checkingAccount2 = bank.createCheckingAccount("������", 300000, 100000);

            // ��ü ���� ���� ���
            bank.printAllAccounts();

            // 2. �Ա� �׽�Ʈ
            System.out.println("\n2. �Ա� �׽�Ʈ");
            System.out.println("===============");

            bank.deposit(savingsAccount1, 50000);
            bank.deposit(checkingAccount1, 25000);

            // 3. ��� �׽�Ʈ
            System.out.println("\n3. ��� �׽�Ʈ");
            System.out.println("===============");

            bank.withdraw(savingsAccount1, 30000);
            bank.withdraw(checkingAccount1, 20000);

            // 4. ���� ���� �׽�Ʈ
            System.out.println("\n4. ���� ���� �׽�Ʈ");
            System.out.println("==================");

            bank.applyInterest(savingsAccount1);
            bank.applyInterest(savingsAccount2);

            // 5. ���� ��ü �׽�Ʈ
            System.out.println("\n5. ���� ��ü �׽�Ʈ");
            System.out.println("==================");

            bank.transfer(savingsAccount2, checkingAccount2, 50000);

            // ���� ���� ���
            bank.printAllAccounts();

            // 6. ���� ó�� �׽�Ʈ
            System.out.println("\n6. ���� ó�� �׽�Ʈ");
            System.out.println("==================");

            // 6-1. �ܾ� ���� ���� �׽�Ʈ
            System.out.println("\n6-1. �ܾ� ���� ���� �׽�Ʈ:");
            try {
                bank.withdraw(savingsAccount1, 1000000); // �ܾ׺��� ū �ݾ� ��� �õ�
            } catch (InsufficientBalanceException e) {
                System.out.println("���� �߻�: " + e.getMessage());
                System.out.printf("�����ܾ�: %.0f��, ��û�ݾ�: %.0f��\n", 
                                e.getCurrentBalance(), e.getRequestedAmount());
            }

            // 6-2. ��� �ѵ� �ʰ� ���� �׽�Ʈ
            System.out.println("\n6-2. ��� �ѵ� �ʰ� ���� �׽�Ʈ:");
            try {
                bank.withdraw(checkingAccount1, 60000); // ��� �ѵ����� ū �ݾ� ��� �õ�
            } catch (WithdrawalLimitExceededException e) {
                System.out.println("���� �߻�: " + e.getMessage());
                System.out.printf("����ѵ�: %.0f��\n", e.getWithdrawalLimit());
            } catch (InsufficientBalanceException e) {
                System.out.println("���� �߻�: " + e.getMessage());
            }

            // 6-3. ���¸� ã�� �� ���� ���� �׽�Ʈ
            System.out.println("\n6-3. ���� ������ ���� �׽�Ʈ:");
            try {
                bank.deposit(9999, 10000); // �������� �ʴ� ���¹�ȣ
            } catch (AccountNotFoundException e) {
                System.out.println("���� �߻�: " + e.getMessage());
            }

            // 7. ���� ���� ���
            System.out.println("\n7. ���� ���� ����");
            System.out.println("==================");
            bank.printAllAccounts();

            System.out.printf("\n�� ���� ��: %d��\n", bank.getAccountCount());
            System.out.printf("���� ���¹�ȣ: %d\n", bank.getNextAccountNumber());

        } catch (AccountNotFoundException e) {
            System.out.println("���¸� ã�� �� �����ϴ�: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("�ܾ��� �����մϴ�: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("����ġ ���� ������ �߻��߽��ϴ�: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n=== ���� �ý��� �׽�Ʈ �Ϸ� ===");
    }
}
