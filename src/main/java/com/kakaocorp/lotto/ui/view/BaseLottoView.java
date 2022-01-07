package com.kakaocorp.lotto.ui.view;

public interface BaseLottoView {

    void printLessThanMinimum(int minimum);
    void printGreaterThanMaximum(int maximum);
    void printDuplicateNotAllowed();
    void printValueNotAllowed(int value);
    void printWrongSize(int expected);
    void printNumberFormatError();
}
