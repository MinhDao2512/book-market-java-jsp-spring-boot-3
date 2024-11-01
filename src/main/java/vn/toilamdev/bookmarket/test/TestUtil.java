package vn.toilamdev.bookmarket.test;

public class TestUtil {
    public static void main(String[] args) {
        String email = "nguyenminhdao@gmail.com";
        String[] res = email.split("@");

        for (String x : res) {
            System.out.println(x);
        }

        System.out.println(res[0]);
    }
}
