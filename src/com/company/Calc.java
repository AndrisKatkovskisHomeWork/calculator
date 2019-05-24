package com.company;

public class Calc {
    private UiGenerator uiGenerator;
    private Calculations c;

    public Calc() {
        c = new Calculations();
        drawUI();
    }

    public void drawUI() {
        uiGenerator = new UiGenerator(c);
        uiGenerator.generateUI();
    }
}
