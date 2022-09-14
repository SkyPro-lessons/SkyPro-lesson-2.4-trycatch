package site.telion;

import site.telion.exceptions.WrongLoginException;
import site.telion.exceptions.WrongPasswordException;

public class InputVerification {
    private String login;
    private String password;
    private String confirmPassword;

    public InputVerification(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public boolean checkLoginParameters() {
        try {
            if (!this.checkLogin() || !this.checkPassword()) {
                return false;
            }
            this.checkConfirmPassword();
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean checkLogin() {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин не может содержать более 20 символов, текущий размер равен " + login.length());
        }
        if (!login.matches("^[a-zA-Z0-9_]*$")) {
            System.out.println("Логин содержит некорректные символы");
            return false;
        }
        return true;
    }

    public boolean checkPassword() {
        if (password.length() >= 20) {
            throw new WrongPasswordException("Пароль не может содержать 20 и более символов, текущий размер равен " + password.length());
        }
        if (!password.matches("^[a-zA-Z0-9_]*$")) {
            System.out.println("Пароль содержит некорректные символы");
            return false;
        }
        return true;
    }

    public void checkConfirmPassword() {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают: " + password + " и " + confirmPassword);
        }
    }
}
