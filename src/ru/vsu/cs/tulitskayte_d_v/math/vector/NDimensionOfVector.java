package ru.vsu.cs.tulitskayte_d_v.math.vector;

import ru.vsu.cs.tulitskayte_d_v.math.matrix.MathExceptions;

public abstract class NDimensionOfVector implements Vector {
    protected int size;
    protected float[] values;

    public NDimensionOfVector(int size, float[] values) {
        if (values.length != size) {
            throw new IllegalArgumentException("Invalid vector size");
        }
        this.size = size;
        this.values = values;
    }

    @Override
    public void minusTwoVectors(final Vector v1, final Vector v2) {
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("One of the vectors is equal to zero");
        }
        if (v1.getSize() != v2.getSize()) {
            throw new IllegalArgumentException("The dimensions of the vectors are not the same");
        }
        float[] tmp = new float[v1.getSize()];
        for (int i = 0; i < v1.getSize(); i++) {
            tmp[i] = v1.getValues()[i] - v2.getValues()[i];
        }

        this.values = tmp;
        this.size = tmp.length;

    }

    @Override
    public Vector productVectorOnScalar(final Vector v1, final float scalar) {
        float[] tmp = new float[v1.getSize()];
        for (int i = 0; i < v1.getSize(); i++) {
            tmp[i] = v1.getValues()[i] * scalar;
        }

        this.values = tmp;
        this.size = tmp.length;

        return this;
    }

    @Override
    public Vector divisionVectorOnScalar(final Vector v1, final float scalar) {
        if (v1 == null) {
            throw new IllegalArgumentException("Vector is null");
        }
        if (scalar == 0) {
            throw new IllegalArgumentException("Division by zero");
        }

        float[] tmp = new float[v1.getSize()];

        for (int i = 0; i < v1.getSize(); i++) {
            tmp[i] = v1.getValues()[i] / scalar;
        }

        this.values = tmp;
        this.size = tmp.length;

        return this;
    }

    @Override
    public abstract void vectorCrossProduct(final Vector v2);

    protected abstract boolean checkLengthInputValues(final float[] values);

    @Override
    public float[] getValues() {
        return values;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setValues(final float[] values) {
        if (checkLengthInputValues(values)) {
            this.values = values;
            this.size = values.length;
        } else throw new MathExceptions();
    }

    @Override
    public void sumVectors(final Vector v2) {
        if (this.getSize() != v2.getSize()) {
            throw new MathExceptions();
        }
        float[] tmp = new float[this.getSize()];
        for (int i = 0; i < this.getSize(); i++) {
            tmp[i] = this.getValues()[i] + v2.getValues()[i];
        }
        this.values = tmp;
        this.size = tmp.length;
    }

    @Override
    public void sumVectors(final Vector v1, final Vector v2) {
        if (v1.getSize() != v2.getSize()) {
            throw new MathExceptions();
        }
        float[] tmp = new float[v1.getSize()];
        for (int i = 0; i < v1.getSize(); i++) {
            tmp[i] = v1.getValues()[i] + v2.getValues()[i];
        }
        this.values = tmp;
        this.size = tmp.length;
    }

    @Override
    public void minusTwoVectors(final Vector v2) {
        if (this.getSize() != v2.getSize()) {
            throw new MathExceptions();
        }
        float[] tmp = new float[this.getSize()];
        for (int i = 0; i < this.getSize(); i++) {
            tmp[i] = this.getValues()[i] - v2.getValues()[i];
        }
        this.values = tmp;
        this.size = tmp.length;
    }

    @Override
    public void productVectorOnScalar(final float scalar) {
        float[] tmp = new float[this.getSize()];
        for (int i = 0; i < this.getSize(); i++) {
            tmp[i] = this.getValues()[i] * scalar;
        }
        this.values = tmp;
        this.size = tmp.length;
    }

    @Override
    public void divisionVectorOnScalar(final float scalar) {
        float[] tmp = new float[this.getSize()];
        if (scalar == 0) {
            throw new MathExceptions();
        }
        for (int i = 0; i < this.getSize(); i++) {
            tmp[i] = this.getValues()[i] / scalar;
        }
        this.values = tmp;
        this.size = tmp.length;
    }

    @Override
    public float vectorLength(final Vector v1) {
        float sum = 0;
        for (float value : this.values) {
            sum += value * value;
        }
        return (float) Math.sqrt(sum);
    }

    @Override
    public Vector vectorNormalization() {
        float[] tmp = new float[this.getSize()];
        float length = this.vectorLength(this);
        for (int i = 0; i < this.getSize(); i++) {
            tmp[i] = this.getValues()[i] / length;
        }
        this.values = tmp;
        this.size = tmp.length;
        return this;
    }


    @Override
    public float vectorDotProduct(final Vector v2) {
        float tmp = 0;
        if (this.getSize() == v2.getSize()) {
            for (int i = 0; i < this.getSize(); i++) {
                tmp = tmp + this.getValues()[i] * v2.getValues()[i];
            }
        } else throw new MathExceptions();
        return tmp;
    }
}