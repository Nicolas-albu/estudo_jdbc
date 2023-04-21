package com.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigData {
    private static final Dotenv configs = Dotenv.configure().load();

    public static String getUrlDatabase() {
        return String.format("jdbc:%s://%s:%s/%s",
                configs.get("DB_TYPE"),
                configs.get("DB_HOST"),
                configs.get("DB_PORT"),
                configs.get("DB_NAME"));
    }

    public static String getDB_USER() {
        return configs.get("DB_USER");
    }

    public static String getDB_PASSWORD() {
        return configs.get("DB_PASSWORD");
    }
}
