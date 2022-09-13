package site.telion;

import site.telion.exceptions.WrongLoginException;
import site.telion.exceptions.WrongPasswordException;

public class Main {

    public static void main(String[] args) {
        printResult("java_skypro.go", "D_1hWiKjjP_9", "D_1hWiKjjP_9"); // ожидаю true: логин корректный, пароли совпадают
        printResult("java_skypro.gojava_skypro.go", "D_1hWiKjjP_9", "D_1hWiKjjP_9"); // ожидаю false: логин не корректный, пароли совпадают
        printResult("java_skypro.go", "D_1hWiKjjP_9D_1hWiKjjP_9", "D_1hWiKjjP_9D_1hWiKjjP_9"); // ожидаю false: пароль не корректный, пароли совпадают
        printResult("java_skypro.go", "D_1hWiKjjP_9", "D_1hWiKjjP_1"); // ожидаю false: логин и пароль корректный, пароли не совпадают
    }

    public static boolean checkLoginParameters(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20) {
                throw new WrongLoginException("Логин не может содержать более 20 символов, текущий размер равен " + login.length());
            }
            if (password.length() >= 20) {
                throw new WrongPasswordException("Пароль не может содержать 20 и более символов, текущий размер равен " + password.length());
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают: " + password + " и " + confirmPassword);
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return false;
        }

        return true;
    }

    public static void printResult(String login, String password, String confirmPassword) {
        System.out.println("\r\n" + "Login: " + login + ", " +
                "Password: " + password + ", " +
                "Confirm: " + confirmPassword);
        boolean result = checkLoginParameters(login, password, confirmPassword);
        System.out.println("result = " + result);
    }
}
