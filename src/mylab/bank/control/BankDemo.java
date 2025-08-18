package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

/**
 * 은행 시스템의 기능을 테스트하는 클래스
 */
public class BankDemo {

    public static void main(String[] args) {

        // 은행 시스템 초기화
        Bank bank = new Bank();

        System.out.println("\n=== 은행 시스템 테스트 시작 ===\n");

        try {
            // 1. 계좌 생성 테스트
            System.out.println("1. 계좌 생성 테스트");
            System.out.println("==================");

            int savingsAccount1 = bank.createSavingsAccount("김철수", 100000, 3.0);
            int savingsAccount2 = bank.createSavingsAccount("이영희", 200000, 2.5);
            int checkingAccount1 = bank.createCheckingAccount("박민수", 150000, 50000);
            int checkingAccount2 = bank.createCheckingAccount("최지원", 300000, 100000);

            // 전체 계좌 정보 출력
            bank.printAllAccounts();

            // 2. 입금 테스트
            System.out.println("\n2. 입금 테스트");
            System.out.println("===============");

            bank.deposit(savingsAccount1, 50000);
            bank.deposit(checkingAccount1, 25000);

            // 3. 출금 테스트
            System.out.println("\n3. 출금 테스트");
            System.out.println("===============");

            bank.withdraw(savingsAccount1, 30000);
            bank.withdraw(checkingAccount1, 20000);

            // 4. 이자 적용 테스트
            System.out.println("\n4. 이자 적용 테스트");
            System.out.println("==================");

            bank.applyInterest(savingsAccount1);
            bank.applyInterest(savingsAccount2);

            // 5. 계좌 이체 테스트
            System.out.println("\n5. 계좌 이체 테스트");
            System.out.println("==================");

            bank.transfer(savingsAccount2, checkingAccount2, 50000);

            // 현재 상태 출력
            bank.printAllAccounts();

            // 6. 예외 처리 테스트
            System.out.println("\n6. 예외 처리 테스트");
            System.out.println("==================");

            // 6-1. 잔액 부족 예외 테스트
            System.out.println("\n6-1. 잔액 부족 예외 테스트:");
            try {
                bank.withdraw(savingsAccount1, 1000000); // 잔액보다 큰 금액 출금 시도
            } catch (InsufficientBalanceException e) {
                System.out.println("예외 발생: " + e.getMessage());
                System.out.printf("현재잔액: %.0f원, 요청금액: %.0f원\n", 
                                e.getCurrentBalance(), e.getRequestedAmount());
            }

            // 6-2. 출금 한도 초과 예외 테스트
            System.out.println("\n6-2. 출금 한도 초과 예외 테스트:");
            try {
                bank.withdraw(checkingAccount1, 60000); // 출금 한도보다 큰 금액 출금 시도
            } catch (WithdrawalLimitExceededException e) {
                System.out.println("예외 발생: " + e.getMessage());
                System.out.printf("출금한도: %.0f원\n", e.getWithdrawalLimit());
            } catch (InsufficientBalanceException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }

            // 6-3. 계좌를 찾을 수 없는 예외 테스트
            System.out.println("\n6-3. 계좌 미존재 예외 테스트:");
            try {
                bank.deposit(9999, 10000); // 존재하지 않는 계좌번호
            } catch (AccountNotFoundException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }

            // 7. 최종 상태 출력
            System.out.println("\n7. 최종 계좌 상태");
            System.out.println("==================");
            bank.printAllAccounts();

            System.out.printf("\n총 계좌 수: %d개\n", bank.getAccountCount());
            System.out.printf("다음 계좌번호: %d\n", bank.getNextAccountNumber());

        } catch (AccountNotFoundException e) {
            System.out.println("계좌를 찾을 수 없습니다: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("잔액이 부족합니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예상치 못한 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n=== 은행 시스템 테스트 완료 ===");
    }
}
