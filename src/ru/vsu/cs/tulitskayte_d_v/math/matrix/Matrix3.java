package ru.vsu.cs.tulitskayte_d_v.math.matrix;

import ru.vsu.cs.tulitskayte_d_v.math.vector.Vector;
import ru.vsu.cs.tulitskayte_d_v.math.vector.Vector3;

public class Matrix3 extends NDimensionalityOfSquareMatrix implements Matrix {

    public Matrix3(float[][] values) {
        super(3, values);
    }

    public Matrix3() {
        super(3, new float[3][3]);
    }

    @Override
    public void setZeroMatrix() {
        setValue(new float[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
    }

    @Override
    public void setSingleMatrix() {
        setValue(new float[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });
    }

    @Override
    protected boolean checkLengthInputValues(final float[][] values) {
        return super.isValidSize(values, 3);
    }

    @Override
    public Vector productMatrixOnVector(final Matrix m1, final Vector v1) {
        Vector vRes = new Vector3();
        float[] tmp = super.getMatrixAfterProductMatrixOnVector(m1, v1);
        vRes.setValues(tmp);
        return vRes;
    }
}