package site.telion;

public class Main {

    public static void main(String[] args) {
        printResult("java_skypro.go", "D_1hWiKjjP_9", "D_1hWiKjjP_9"); // ожидаю false: логин содержит некорректные символы, пароли совпадают
        printResult("java_skyprogo", "D_1hWiKjjP_9", "D_1hWiKjjP_9"); // ожидаю true: логин корректный, пароли совпадают
        printResult("java_skyprogojava_skyprogo", "D_1hWiKjjP_9", "D_1hWiKjjP_9"); // ожидаю false: логин не корректный, пароли совпадают
        printResult("java_skyprogo", "D_1hWiKjjP_9D_1hWiKjjP_9", "D_1hWiKjjP_9D_1hWiKjjP_9"); // ожидаю false: пароль не корректный, пароли совпадают
        printResult("java_skyprogo", "D_1hWiKjjP_9", "D_1hWiKjjP_1"); // ожидаю false: логин и пароль корректный, пароли не совпадают
    }

    public static void printResult(String login, String password, String confirmPassword) {
        InputVerification verification = new InputVerification(login, password, confirmPassword);
        System.out.println("\r\n" + "Login: " + login + ", " +
                "Password: " + password + ", " +
                "Confirm: " + confirmPassword);
        boolean result = verification.checkLoginParameters();
        System.out.println("result = " + result);
    }
}
