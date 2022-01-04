package step2.view;

import java.util.*;

public interface View {
    // 웹 브라우저와 같이 쿠키를 저장하는 로직
    Map<String, String> Cookie = new HashMap<>();

    String COOKIE_KEY_USER_ID = "userId";

    default String getCookie(String key){
        return Cookie.get(key);
    }

    default void setUserIdCookie(String key, String value){
        Cookie.put(COOKIE_KEY_USER_ID, value);
    }
}
