package com.example.design.StatePattern.state;

import com.example.design.StatePattern.context.AirContext;
import com.example.design.StatePattern.context.Context;

/**
 * @Description
 * @Date 2022/11/3 17:41
 * @Author by liu.huan
 */
public abstract class FileState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void createFile(String fileName);

    public abstract void parseFile(String fileName);

    public abstract void deleteFile(String fileName);

}
