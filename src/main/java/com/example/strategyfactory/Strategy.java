package com.example.strategyfactory;

public interface Strategy {
    double compute(long money);
    int getType();
}
