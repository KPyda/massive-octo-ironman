package com.testspring.app;

/**
 * Created by Praktykant on 02.09.14.
 */
public class Logging {

    // Before selected method execution
    public void beforeAdvice() {
        System.out.println("Before advice");
    }

    // After selected method execution
    public void afterAdvice() {
        System.out.println("After advice");
    }

    // Execute after selected method returns
    public void afterReturningAdvice(Object retVal) {
        System.out.println("After returning advice: " + retVal.toString());
    }

    // Execute after selected method throws exception
    public void AfterThrowingAdvice(IllegalArgumentException e) {
        System.out.println("After throwing advice: " + e.toString());
    }
}
