package mylab.bank.entity;

import java.util.ArrayList;
import mylab.bank.exception.*;

/**
 * 은행 시스템의 주요 관리 클래스
 */
public class Bank {

    private ArrayList<Account> accounts;        // 계좌 목록
    private int nextAccountNumber;              // 다음 계좌번호

    /**
     * Bank 생성자 - ArrayList 객체생성, nextAccountNumber = 1000으로 초기화
     */
    public Bank() {
        accounts = new ArrayList<Account>();
        nextAccountNumber = 1000;
        System.out.println("은행 시스템이 초기화되었습니다.");
    }

    /**
     * 저축 계좌 생성
     * @param ownerName 계좌소유자 이름
     * @param initialBalance 초기 잔액
     * @param interestRate 이자율
     * @return 생성된 계좌번호
     */
    public int createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        int accountNumber = nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.printf("저축 계좌가 생성되었습니다. 계좌번호: %d, 소유자: %s\n", 
                        accountNumber, ownerName);
        return accountNumber;
    }

    /**
     * 체킹 계좌 생성
     * @param ownerName 계좌소유자 이름
     * @param initialBalance 초기 잔액
     * @param withdrawalLimit 출금 한도
     * @return 생성된 계좌번호
     */
    public int createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        int accountNumber = nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.printf("체킹 계좌가 생성되었습니다. 계좌번호: %d, 소유자: %s\n", 
                        accountNumber, ownerName);
        return accountNumber;
    }

    /**
     * 계좌 조회
     * @param accountNumber 계좌번호
     * @return 계좌 객체
     * @throws AccountNotFoundException 계좌를 찾을 수 없을 때
     */
    public Account findAccount(int accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException(String.valueOf(accountNumber), "해당 계좌번호가 존재하지 않습니다.");
    }

    /**
     * 입금
     * @param accountNumber 계좌번호
     * @param amount 입금할 금액
     * @throws AccountNotFoundException 계좌를 찾을 수 없을 때
     */
    public void deposit(int accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    /**
     * 출금
     * @param accountNumber 계좌번호
     * @param amount 출금할 금액
     * @throws AccountNotFoundException 계좌를 찾을 수 없을 때
     * @throws InsufficientBalanceException 잔액 부족시
     */
    public void withdraw(int accountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    /**
     * 계좌 이체
     * @param fromAccountNumber 출금 계좌번호
     * @param toAccountNumber 입금 계좌번호
     * @param amount 이체할 금액
     * @throws AccountNotFoundException 계좌를 찾을 수 없을 때
     * @throws InsufficientBalanceException 잔액 부족시
     */
    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {

        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        // 출금 (예외 발생 가능)
        fromAccount.withdraw(amount);

        // 입금 (출금이 성공한 경우에만 실행)
        toAccount.deposit(amount);

        System.out.printf("계좌 이체 완료: %d → %d, %.0f원\n", 
                        fromAccountNumber, toAccountNumber, amount);
    }

    /**
     * 저축 계좌 이자 적용
     * @param accountNumber 계좌번호
     * @throws AccountNotFoundException 계좌를 찾을 수 없을 때
     */
    public void applyInterest(int accountNumber) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        if (account instanceof SavingsAccount) {
            ((SavingsAccount) account).applyInterest();
        } else {
            System.out.println("저축 계좌가 아닙니다. 이자를 적용할 수 없습니다.");
        }
    }

    /**
     * 모든 계좌 정보 출력
     */
    public void printAllAccounts() {
        System.out.println("\n=== 전체 계좌 정보 ===");
        if (accounts.isEmpty()) {
            System.out.println("등록된 계좌가 없습니다.");
        } else {
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
        System.out.println("==================");
    }

    /**
     * 총 계좌 수 반환
     * @return 계좌 수
     */
    public int getAccountCount() {
        return accounts.size();
    }

    /**
     * 다음 계좌번호 반환
     * @return 다음 계좌번호
     */
    public int getNextAccountNumber() {
        return nextAccountNumber;
    }
}
