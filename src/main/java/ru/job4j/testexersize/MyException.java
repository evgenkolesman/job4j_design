package ru.job4j.testexersize;

public class MyException extends Exception {
    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
