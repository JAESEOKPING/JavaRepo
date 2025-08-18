package mylab.bank.entity;

import mylab.bank.exception.*;

/**
 * 체킹 계좌를 표현하는 클래스 (Account 클래스 상속)
 */
public class CheckingAccount extends Account {

    private double withdrawalLimit;     // 출금 한도

    /**
     * CheckingAccount 생성자
     * @param accountNumber 계좌번호
     * @param ownerName 계좌소유자 이름
     * @param initialBalance 초기 잔액
     * @param withdrawalLimit 출금 한도
     */
    public CheckingAccount(int accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    /**
     * 입금 메소드
     * @param amount 입금할 금액
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("[체킹계좌 %d] %.0f원 입금 완료. 현재 잔액: %.0f원\n", 
                            accountNumber, amount, balance);
        } else {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
    }

    /**
     * 출금 메소드
     * @param amount 출금할 금액
     * @throws InsufficientBalanceException 잔액 부족시
     * @throws WithdrawalLimitExceededException 출금 한도 초과시
     */
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("출금 금액은 0보다 커야 합니다.");
            return;
        }

        // 출금 한도 검사
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(withdrawalLimit, amount);
        }

        // 잔액 검사
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }

        balance -= amount;
        System.out.printf("[체킹계좌 %d] %.0f원 출금 완료. 현재 잔액: %.0f원\n", 
                        accountNumber, amount, balance);
    }

    // Getter 메소드
    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    // Setter 메소드
    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public String toString() {
        return String.format("[체킹계좌] 계좌번호: %d, 소유자: %s, 잔액: %.0f원, 출금한도: %.0f원", 
                           accountNumber, ownerName, balance, withdrawalLimit);
    }
}
