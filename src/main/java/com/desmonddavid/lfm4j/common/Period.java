package com.desmonddavid.lfm4j.common;

public enum Period {
    OVERALL("overall"),
    SEVEN_DAY("7day"),
    ONE_MONTH("1month"),
    THREE_MONTH("3month"),
    SIX_MONTH("6month"),
    TWELVE_MONTH("12month");

    public final String value;

    Period(String value) {
        this.value = value;
    }
}
