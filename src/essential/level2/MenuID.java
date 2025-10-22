package essential.level2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MenuID {


    /*메뉴 아이디 할당 : MenuID =String*/
    private Map<String, MenuItem> menuMap = new LinkedHashMap<>();

    /*생성자*/
    public MenuID() {
        /*메뉴 추가*/
        menuMap.put("버거1", new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuMap.put("버거2", new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuMap.put("버거3", new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuMap.put("버거4", new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

    }

    /*게터*/
    public MenuItem get(String id) {
        return menuMap.get(id);
    }

    /*게터 전체*/
    public Map<String, MenuItem> all() {
        return menuMap;
    }

    /*세터*/
    public void setMenuMap(Map<String, MenuItem> menuMap) {
        this.menuMap = menuMap;
    }
}
