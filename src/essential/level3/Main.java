package essential.level3;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double selectNo = 99999;

            /*Kiosk클래스 실행 반복문*/
            while (selectNo != 0) {

                Kiosk kiosk = new Kiosk();
                System.out.println("안녕하세요 SHAKESHACK입니다.");
                System.out.println("키오스크를 실행하시겠습니까?");
                System.out.printf("%-4s | %-14s\n",
                        "1.", "실행");
                System.out.printf("%-4s | %-14s\n",
                        "0.", "종료");

                /*스캐너입력-selectNo할당*/
                selectNo = getSelectNo(sc);

                /*번호알고리즘*/
                if (selectNo == 0) {
                    System.out.println("프로그램을 종료합니다.\n");
                } else if (selectNo == 1) {
                    kiosk.start(kiosk.getMenuAll(), sc, kiosk);
                } else {
                    System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
                }

            }

        }

    }

    /*스캐너입력-selectNo할당 메서드*/
    public static double getSelectNo(Scanner sc) {
        double selectNo;
        try {
            selectNo = sc.nextDouble();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("메뉴와 일치하는 숫자를 입력해야 합니다.");
        }
        return selectNo;
    }
}
