package com.kreitek.pets.domain;

import com.kreitek.pets.Controller;
import com.kreitek.pets.VariablesGlobales;

public class DebugLogger {
    private static volatile DebugLogger instance = null;

    private DebugLogger(){
        if (instance != null){
            throw new RuntimeException("Usage getDebugLogger method to create");
        }
    }

    public static DebugLogger getInstance(){
        if (instance == null){
            synchronized (DebugLogger.class){
                if (instance == null){
                    instance = new DebugLogger();
                }
            }
        }
        return instance;
    }

    public void debug(String mensageDebug){
        System.out.println("[debug]"+"["+ VariablesGlobales.CONTADOR_DEBUG+"] - "+ mensageDebug);
        VariablesGlobales.CONTADOR_DEBUG += 1;
    }
}