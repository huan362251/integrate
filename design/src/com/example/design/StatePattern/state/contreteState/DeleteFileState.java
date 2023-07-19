package com.example.design.StatePattern.state.contreteState;

import com.example.design.StatePattern.context.Context;
import com.example.design.StatePattern.state.FileState;

/**
 * @Description
 * @Date 2022/11/3 17:48
 * @Author by liu.huan
 */
public class DeleteFileState extends FileState {

    @Override
    public void createFile(String fileName) {
        this.context.setCurrentState(Context.createFileState);
        this.context.createFile(fileName);
    }

    @Override
    public void parseFile(String fileName) {
        System.out.println("文件不存在，不允许解析");
    }

    @Override
    public void deleteFile(String fileName) {
        System.out.println("删除文件");
    }

}
