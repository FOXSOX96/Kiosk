package challenge.level2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Discount {

    /*속성*/
    private Map<String, Integer> discountMap = new LinkedHashMap<>();


    /*생성자*/
    public Discount() {
        discountMap.put("국가유공자", 10);
        discountMap.put("군인", 5);
        discountMap.put("학생", 3);
        discountMap.put("일반", 0);
    }

    /*기능*/
    /*게터*/
    public Map<String, Integer> getDiscountMap() {
        return discountMap;
    }
    public Integer getDiscount(String type) {
        return discountMap.get(type);
    }
    /*인덱스로 key게터*/
    public String getDiscountKey(int index) {
        List<String> keys = new ArrayList<>(discountMap.keySet());
        if (index < 0 || index >= keys.size()) {
            throw new IndexOutOfBoundsException("할인 정보가 없습니다.");
        };
        return keys.get(index);
    }

    /*세터*/
    public void addDiscount(String type, int discount) {
        this.discountMap.put(type, discount);
    }
}
