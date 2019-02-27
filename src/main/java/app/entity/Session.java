package app.entity;

import java.time.LocalDateTime;
import java.util.List;

// /cart/5 POST
// /cart GET
public class Session {
    private String token;
    private User user;
    private LocalDateTime expireDate;
    private List<Product> cart;

    public Session(String token, User user, LocalDateTime expireDate) {
        this.token = token;
        this.user = user;
        this.expireDate = expireDate;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

}
