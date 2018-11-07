package net.asherchurch.book.utils;

public enum ExtraKeys {
    ROOTING_YN("rooting_device");

    private String value;
    ExtraKeys(String keyword) {
        this.value = "net.asherchurch.book." + keyword;
    }

    public  String  valueOf() {
        return this.value;
    }
}
