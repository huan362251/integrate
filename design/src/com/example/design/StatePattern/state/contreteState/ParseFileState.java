package com.example.design.StatePattern.state.contreteState;

import com.example.design.StatePattern.context.Context;
import com.example.design.StatePattern.state.FileState;

/**
 * @Description
 * @Date 2022/11/3 17:48
 * @Author by liu.huan
 */
public class ParseFileState extends FileState {

    @Override
    public void createFile(String fileName) {
        System.out.println("不允许再创建");
    }

    @Override
    public void parseFile(String fileName) {
        System.out.println("解析文件：" + fileName);
    }

    @Override
    public void deleteFile(String fileName) {
        this.context.setCurrentState(Context.deleteFileState);
        this.context.deleteFile(fileName);
    }

}
