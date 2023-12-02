package ru.vsu.cs.tulitskayte_d_v.math.matrix;

import ru.vsu.cs.tulitskayte_d_v.math.vector.Vector;
import ru.vsu.cs.tulitskayte_d_v.math.vector.Vector4;

public class Matrix4 extends NDimensionalityOfSquareMatrix implements Matrix {

    public Matrix4(float[][] values) {
        super(4, values);
    }

    public Matrix4(){
        super(4, new float[4][4]);
    }

    @Override
    public void setZeroMatrix() {
        setValue(new float[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });
    }

    @Override
    public void setSingleMatrix() {
        setValue(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
    }

    @Override
    protected boolean checkLengthInputValues(final float[][] values) {
        return super.isValidSize(values, 4);
    }

    @Override
    public Vector productMatrixOnVector(final Matrix m1, final Vector v1) {
        Vector vRes = new Vector4();
        float[] tmp = super.getMatrixAfterProductMatrixOnVector(m1, v1);
        vRes.setValues(tmp);
        return vRes;
    }
}