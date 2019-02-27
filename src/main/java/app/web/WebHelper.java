package app.web;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

public class WebHelper {

    public String getTokenFromCookies(Cookie[] cookies){
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("user-token")){
                return cookie.getValue();
            }
        }
        return null;
    }
}
