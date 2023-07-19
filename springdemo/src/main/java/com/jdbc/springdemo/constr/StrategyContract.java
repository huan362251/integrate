package com.jdbc.springdemo.constr;

/**
 * 进一步优化就是将这个进行枚举转换，对外提供易识别的标识，内部再映射具体类，然后进行转换
 */
public class StrategyContract {

    /**
     * CHECK_OUT
     */
    public static final String CHECK_OUT_BLOB = "checkOutBlobFileGain";

    public static final String CHECK_OUT_SFTP = "checkOutSftpFileGain";

    public static final String CHECK_OUT_SERVER = "checkOutServerFileGain";

    /**
     * SAFE_CHANGE
     */
    public static final String SAFE_CHANGE_BLOB = "safeChangeBlobFileGain";

    public static final String SAFE_CHANGE_SFTP = "safeChangeSftpFileGain";

    public static final String SAFE_CHANGE_SERVER = "safeChangeServerFileGain";



}
