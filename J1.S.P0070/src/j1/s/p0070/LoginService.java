package j1.s.p0070;

import java.util.Scanner;
import java.util.ResourceBundle;
import java.util.Random;
import java.util.Locale;
import java.util.ArrayList;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginService {

    private final static Scanner sc = new Scanner(System.in);
    private final static Random rd = new Random();
    private ResourceBundle bundle;
    private final ArrayList<User> list = new ArrayList<>();

    public LoginService() {
        list.add(new User("0965551664", passwordEncryption("hoang04122005")));
        list.add(new User("0412200555", passwordEncryption("hoang12345")));
        list.add(new User("0987654321", passwordEncryption("abc123456")));
        list.add(new User("0123456789", passwordEncryption("pass2026")));
        list.add(new User("0909090909", passwordEncryption("test1234")));
        list.add(new User("0911223344", passwordEncryption("user9999")));
        list.add(new User("0334455667", passwordEncryption("banking01")));
        list.add(new User("0778899001", passwordEncryption("secure123")));
        list.add(new User("0887766554", passwordEncryption("hello2026")));
        list.add(new User("0991122334", passwordEncryption("demo12345")));
    }

    public void displayMenu() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.println("Please choice one option: ");
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("loginebanksystem.Language", locale);
    }

    private String checkAccountNumber(String accountNumber) {
        if (!accountNumber.matches("^[0-9]{10}$")) {
            return bundle.getString("account.error");
        }
        return null;
    }

    private String checkPassword(String password) {
        if (password.length() < 8 || password.length() > 31
                || !password.matches("^[A-Za-z0-9]+$")
                || !password.matches(".*[A-Za-z].*")
                || !password.matches(".*[0-9].*")) {
            return bundle.getString("password.error");
        }
        return null;
    }

    private String generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            captcha.append(chars.charAt(rd.nextInt(chars.length())));
        }
        return captcha.toString();
    }

    private String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (!captchaInput.equals(captchaGenerate)) {
            return bundle.getString("captcha.error");
        }
        return null;
    }

    private static String passwordEncryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void login() {
        String mess, account, password, captchaGenerate, captchaInput;
        User registeredUsers = null;
        while (true) {
            while (true) {
                System.out.print(bundle.getString("account.input"));
                account = sc.nextLine();

                mess = checkAccountNumber(account);
                if (mess == null) {
                    break;
                }
                System.err.println(mess);
            }

            while (true) {
                System.out.print(bundle.getString("password.input"));
                password = sc.nextLine();

                mess = checkPassword(password);
                if (mess == null) {
                    break;
                }
                System.err.println(mess);
            }

            String inputPasswordHash = passwordEncryption(password);
            for (User user : list) {
                if (account.equals(user.getAccount()) && inputPasswordHash.equals(user.getPassword())) {
                    registeredUsers = user;
                    break;
                }
            }

            if (registeredUsers != null) {
                break;
            }
            System.err.println("THIS ACCOUNT HAS NOT BEEN VERIFIED BY THE SYSTEM");
            System.out.println("PLEASE ENTER AGAIN");
        }

        while (true) {
            captchaGenerate = generateCaptcha();
            System.out.println(bundle.getString("captcha.show") + captchaGenerate);

            System.out.print(bundle.getString("captcha.input"));
            captchaInput = sc.nextLine();

            mess = checkCaptcha(captchaInput, captchaGenerate);
            if (mess == null) {
                break;
            }
            System.err.println(mess);
        }
        System.out.println(bundle.getString("login.success"));
    }

}
