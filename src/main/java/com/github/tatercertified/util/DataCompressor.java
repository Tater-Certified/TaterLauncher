package com.github.tatercertified.util;

public class DataCompressor {
    private String value;
    private String data;
    private String key;
    private String salt;
    public DataCompressor() {
    }
    public DataCompressor(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public DataCompressor(String data, String key, String salt) {
        this.data = data;
        this.key = key;
        this.salt = salt;
    }
    public String getValue() {
        return value;
    }
    public String getData() {
        return data;
    }
    public String getKey() {
        return key;
    }
    public String getSalt() {
        return salt;
    }
}
