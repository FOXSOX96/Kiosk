package challenge.level2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputSc {

    /*속성*/
    public Scanner sc = new Scanner(System.in);
    /*생성자*/
    public InputSc() {}


    /*기능*/
    /*스캐너입력-selectNo할당 메서드*/
    public double getSelectNo() {
        double selectNo;
        try {
            selectNo = sc.nextDouble();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("메뉴와 일치하는 숫자를 입력해야 합니다.");
        }
        return selectNo;
    }

    /*게터*/
    public Scanner getSc() {
        return sc;
    }
}
