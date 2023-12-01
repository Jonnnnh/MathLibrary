package ru.vsu.cs.tulitskayte_d_v.math.matrix;

import ru.vsu.cs.tulitskayte_d_v.math.vector.Vector;
import ru.vsu.cs.tulitskayte_d_v.math.vector.Vector3;

public class Matrix3 extends NDimensionalityOfSquareMatrix implements Matrix {

    public Matrix3(float[][] values) {
        if (checkLengthInputValues(values)) {
            super.value = values;
            super.size = values.length;
        } else {
            throw new MathExceptions();
        }
    }

    public Matrix3() {

    }

    @Override
    public void setZeroMatrix() {
        super.size = 3;
        super.value = new float[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
    }
    @Override
    protected boolean checkLengthInputValues(final float[][] values) {
        return values.length == 3 && values[0].length == 3 && values[1].length == 3 && values[2].length == 3;
    }
    @Override
    public void setSingleMatrix() {
        super.size = 3;
        super.value = new float[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

    }

    @Override
    public Vector productMatrixOnVector(final Matrix m1, final Vector v1) {
        Vector vRes = new Vector3();
        float[] tmp = super.getMatrixAfterProductMatrixOnVector(m1, v1);
        vRes.setValues(tmp);
        return vRes;
    }
}
