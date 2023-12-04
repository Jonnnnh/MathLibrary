package ru.vsu.cs.tulitskayte_d_v.math.matrix;

import ru.vsu.cs.tulitskayte_d_v.math.vector.Vector;

public abstract class NDimensionalityOfSquareMatrix implements Matrix {
    private float[][] value;
    private final int size;

    public NDimensionalityOfSquareMatrix(int size, float[][] values) {
        if (isInvalidLength(values, size)) {
            throw new MathExceptions("Error in values!");
        }
        this.size = size;
        setValue(values);
    }

    protected boolean isInvalidLength(float[][] values, int expectedSize) {
        if (values.length != expectedSize) {
            return true;
        }
        for (float[] row : values) {
            if (row.length != expectedSize) {
                return true;
            }
        }
        return false;
    }

    protected boolean isValidSize(float[][] values, int size) {
        if (values.length != size) {
            return false;
        }
        for (float[] row : values) {
            if (row.length != size) {
                return false;
            }
        }
        return true;
    }

    @Override
    public abstract void setZeroMatrix();

    @Override
    public abstract void setSingleMatrix();

    protected abstract boolean checkLengthInputValues(float[][] values);

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public float[][] getValues() {
        float[][] copy = new float[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(value[i], 0, copy[i], 0, size);
        }
        return copy;
    }

    @Override
    public void setValue(float[][] value) {
        if (isInvalidLength(value, this.size)) {
            throw new MathExceptions();
        }
        this.value = deepCopy(value);
    }

    private float[][] deepCopy(float[][] original) {
        float[][] copy = new float[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    @Override
    public Matrix sumMatrix(final Matrix m1, final Matrix m2) {
        if (m1.getSize() != m2.getSize()) {
            throw new MathExceptions();
        }
        float[][] result = new float[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                result[i][j] = m1.getValues()[i][j] + m2.getValues()[i][j];
            }
        }
        this.setValue(result);
        return this;
    }

    @Override
    public Matrix minusMatrix(final Matrix m1, final Matrix m2) {
        if (m1.getSize() != m2.getSize()) {
            throw new MathExceptions();
        }
        float[][] result = new float[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                result[i][j] = m1.getValues()[i][j] - m2.getValues()[i][j];
            }
        }
        this.setValue(result);
        return this;
    }

    @Override
    public abstract Vector productMatrixOnVector(final Matrix m1, final Vector v1);

    protected float[] getMatrixAfterProductMatrixOnVector(final Matrix m1, final Vector v1) {
        if (m1.getSize() != v1.getSize()) {
            throw new MathExceptions();
        }
        float[] result = new float[m1.getSize()];
        for (int i = 0; i < m1.getSize(); i++) {
            for (int j = 0; j < m1.getSize(); j++) {
                result[i] += m1.getValues()[i][j] * v1.getValues()[j];
            }
        }
        return result;
    }

    @Override
    public void productOnMatrix(final Matrix m1) {
        if (m1.getSize() != this.getSize()) {
            throw new MathExceptions();
        }
        float[][] result = new float[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                for (int k = 0; k < this.size; k++) {
                    result[i][j] += this.getValues()[i][k] * m1.getValues()[k][j];
                }
            }
        }

        this.setValue(result);
    }

    @Override
    public Matrix productTwoMatrix(final Matrix m1, final Matrix m2) {
        if (m1.getSize() != m2.getSize()) {
            throw new MathExceptions();
        }
        float[][] result = new float[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                for (int k = 0; k < this.size; k++) {
                    result[i][j] += m1.getValues()[i][k] * m2.getValues()[k][j];
                }
            }
        }
        this.setValue(result);
        return this;
    }

    @Override
    public Matrix transpose(final Matrix m) {
        float[][] result = new float[m.getSize()][m.getSize()];
        for (int i = 0; i < m.getSize(); i++) {
            for (int j = 0; j < m.getSize(); j++) {
                result[j][i] = m.getValues()[i][j];
            }
        }
        this.setValue(result);
        return this;
    }
}