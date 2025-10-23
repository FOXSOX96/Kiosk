package essential.level3;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        /*Kiosk클래스*/
        Kiosk kiosk = new Kiosk();
        System.out.println("안녕하세요 SHAKESHACK입니다.");
        kiosk.start(kiosk.getMenuAll(), sc, kiosk);



        sc.close();
    }



}
