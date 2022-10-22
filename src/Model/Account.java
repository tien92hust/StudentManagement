package Model;

public class Account {
    private int user;
    private String password;

    public Account() {
    }

    public Account(int user, String password) {
        this.user = user;
        this.password = password;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
