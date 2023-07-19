package com.example.design.StatePattern.context;

import com.example.design.StatePattern.state.FileState;
import com.example.design.StatePattern.state.contreteState.CreateFileState;
import com.example.design.StatePattern.state.contreteState.DeleteFileState;
import com.example.design.StatePattern.state.contreteState.ParseFileState;

/**
 * @Description
 * @Date 2022/11/3 17:41
 * @Author by liu.huan
 */
public class Context {

    public static CreateFileState createFileState = new CreateFileState();
    public static ParseFileState parseFileState = new ParseFileState();
    public static DeleteFileState deleteFileState = new DeleteFileState();

    public FileState currentState = createFileState;

    public Context() {
        this.currentState.setContext(this);
    }

    public void setCurrentState(FileState currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public void createFile(String fileName) {
        this.currentState.createFile(fileName);
    }

    public void parseFile(String fileName) {
        this.currentState.parseFile(fileName);
    }

    public void deleteFile(String fileName) {
        this.currentState.deleteFile(fileName);
    }

}
