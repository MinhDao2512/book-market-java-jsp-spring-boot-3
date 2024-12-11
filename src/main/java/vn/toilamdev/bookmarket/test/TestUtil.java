package vn.toilamdev.bookmarket.test;

import java.util.UUID;

public class TestUtil {
    public static void main(String[] args) {
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);
    }
}
