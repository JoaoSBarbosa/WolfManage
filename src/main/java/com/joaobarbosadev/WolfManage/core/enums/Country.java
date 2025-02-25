package com.joaobarbosadev.WolfManage.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Country {

    BRAZIL("Brasil"),
    USA("Estados Unidos"),
    CANADA("Canada"),
    UK("Reino Unido"),
    GERMANY("Alemanha");

    private final String displayName;
    Country(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static Country fromDisplayName(String value) {
        for (Country country : Country.values()) {
            if (country.displayName.equalsIgnoreCase(value) || country.name().equalsIgnoreCase(value)) {
                return country;
            }
        }
        throw new IllegalArgumentException("País não reconhecido: " + value);
    }
    @Override
    public String toString() {
        return "Country{" +
                "displayName='" + displayName + '\'' +
                '}';
    }
}
