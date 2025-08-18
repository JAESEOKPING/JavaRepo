package mylab.bank.entity;

import mylab.bank.exception.*;

/**
 * 저축 계좌를 표현하는 클래스 (Account 클래스 상속)
 */
public class SavingsAccount extends Account {

    private double interestRate;    // 이자율

    /**
     * SavingsAccount 생성자
     * @param accountNumber 계좌번호
     * @param ownerName 계좌소유자 이름
     * @param initialBalance 초기 잔액
     * @param interestRate 이자율
     */
    public SavingsAccount(int accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    /**
     * 입금 메소드
     * @param amount 입금할 금액
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("[저축계좌 %d] %.0f원 입금 완료. 현재 잔액: %.0f원\n", 
                            accountNumber, amount, balance);
        } else {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
    }

    /**
     * 출금 메소드
     * @param amount 출금할 금액
     * @throws InsufficientBalanceException 잔액 부족시
     */
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("출금 금액은 0보다 커야 합니다.");
            return;
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }

        balance -= amount;
        System.out.printf("[저축계좌 %d] %.0f원 출금 완료. 현재 잔액: %.0f원\n", 
                        accountNumber, amount, balance);
    }

    /**
     * 이자 적용 메소드
     */
    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.printf("[저축계좌 %d] 이자 %.0f원 적용. 현재 잔액: %.0f원 (이자율: %.1f%%)\n", 
                        accountNumber, interest, balance, interestRate);
    }

    // Getter 메소드
    public double getInterestRate() {
        return interestRate;
    }

    // Setter 메소드
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return String.format("[저축계좌] 계좌번호: %d, 소유자: %s, 잔액: %.0f원, 이자율: %.1f%%", 
                           accountNumber, ownerName, balance, interestRate);
    }
}
