package com.jdbc.springdemo.constr;

public enum StrategyEnum {

    CHECK_OUT_BLOB("CHECK_OUT_BLOB","checkOutBlobFileGain"),
    CHECK_OUT_SFTP("CHECK_OUT_SFTP","checkOutSftpFileGain"),
    CHECK_OUT_SERVER("CHECK_OUT_SERVER","checkOutServerFileGain"),
    SAFE_CHANGE_BLOB("SAFE_CHANGE_BLOB","safeChangeBlobFileGain"),
    SAFE_CHANGE_SFTP("SAFE_CHANGE_SFTP","safeChangeSftpFileGain"),
    SAFE_CHANGE_SERVER("SAFE_CHANGE_SERVER","safeChangeServerFileGain")
    ;

    StrategyEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public String matchValue() {
        return value;
    }

    public static String matchValue(String key) {
        StrategyEnum[] strategyEnums = values();
        for (StrategyEnum carTypeEnum : strategyEnums) {
            if (carTypeEnum.key.equals(key)) {
                return carTypeEnum.matchValue();
            }
        }
        return null;
    }

}
