package com.ustudents.fgen.generators;

import com.ustudents.fgen.handlers.CalculationHandler;

public abstract class MemoryGenerator {
    public CalculationHandler handler;
    public int width;
    public int height;
    protected int[][] divergenceIndexes;

    public MemoryGenerator(CalculationHandler handler, int width, int height) {
        this.handler = handler;
        this.width = width;
        this.height = height;
    }

    public void generate() {
        divergenceIndexes = handler.calculateDivergenceIndexes(width, height);
    }
}
