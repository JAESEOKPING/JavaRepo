package mylab.bank.entity;

import mylab.bank.exception.*;

/**
 * 모든 계좌의 기본이 되는 추상 클래스
 */
public abstract class Account {

    protected int accountNumber;        // 계좌번호
    protected String ownerName;         // 계좌소유자 이름
    protected double balance;           // 현재 잔액

    /**
     * Account 생성자
     * @param accountNumber 계좌번호
     * @param ownerName 계좌소유자 이름
     * @param initialBalance 초기 잔액
     */
    public Account(int accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    /**
     * 입금 메소드 (추상 메소드)
     * @param amount 입금할 금액
     */
    public abstract void deposit(double amount);

    /**
     * 출금 메소드 (추상 메소드)
     * @param amount 출금할 금액
     * @throws InsufficientBalanceException 잔액 부족시
     */
    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    // Getter 메소드들
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter 메소드들
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return String.format("계좌번호: %d, 소유자: %s, 잔액: %.0f원", 
                           accountNumber, ownerName, balance);
    }
}
