package essential.level3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Kiosk {


    /*메뉴 아이디 할당 : MenuID =double*/
    private Map<Double, MenuItem> menuMap = new LinkedHashMap<>();

    /*생성자*/
    public Kiosk() {
        /*메뉴 추가*/
        menuMap.put(1.1, new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuMap.put(1.2, new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuMap.put(1.3, new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuMap.put(1.4, new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

    }

    /*메뉴선택 반복문*/
    public void start (Map<Double, MenuItem> getMenuAll, Scanner sc, Kiosk kiosk) {

        /*속성*/
        double selectNo = 99999; /*번호선택*/
        double menuNo = 99999; /*메뉴번호*/

        /* 메뉴선택: 0이 입력되면 종료되는 반복문시작*/
        while (selectNo != 0) {

            System.out.println("[SHAKESHACK MENU ]");
            for (Map.Entry<Double, MenuItem> entry : getMenuAll.entrySet()) {
                Double key = entry.getKey();
                MenuItem item = entry.getValue();
                System.out.printf("%-4s | %-14s (%4.1f) - %s\n",
                        key, item.getMenuName(), item.getMenuPrice(), item.getMenuDetail());
            }
            System.out.println("0. 뒤로가기");

            /*스캐너입력-selectNo할당*/
            System.out.println("메뉴의 번호를 선택해주세요");
            selectNo = Main.getSelectNo(sc);

            /*메뉴번호선택-menuNo할당*/
            if (selectNo == 0) {
                System.out.println("키오스크를 종료합니다.\n");
            } else if (selectNo <= 1 + 0.1 * getMenuAll.size()) {
                menuNo = selectNo;
                kiosk.getMenu(selectNo).ifPresentOrElse(
                        item -> System.out.println(item.getMenuName() + "을 선택하였습니다."),
                        () -> System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.")
                );
            } else {
                System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
            }


        }


    }



    /*게터*/
    public Optional<MenuItem> getMenu(Double MenuID) {
        return Optional.ofNullable(menuMap.get(MenuID));
    }


    /*게터 전체*/
    public Map<Double, MenuItem> getMenuAll() {
        return menuMap;
    }

    /*세터*/
    public void setMenuMap(Map<Double, MenuItem> menuMap) {
        this.menuMap = menuMap;
    }

}
