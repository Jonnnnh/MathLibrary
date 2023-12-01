package ru.vsu.cs.tulitskayte_d_v.math.matrix;

import ru.vsu.cs.tulitskayte_d_v.math.vector.Vector;
import ru.vsu.cs.tulitskayte_d_v.math.vector.Vector4;

public class Matrix4 extends NDimensionalityOfSquareMatrix implements Matrix {

    public Matrix4(float[][] values) {
        if (checkLengthInputValues(values)) {
            super.value = values;
            super.size = values.length;
        } else {
            throw new MathExceptions();
        }
    }

    public Matrix4(){
    }

    @Override
    public void setZeroMatrix() {
        super.size = 4;
        super.value = new float[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
    }

    @Override
    public void setSingleMatrix() {
        super.size = 4;
        super.value = new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

    }

    @Override
    protected boolean checkLengthInputValues(final float[][] values) {
        return values.length == 4 && values[0].length == 4 && values[1].length == 4 &&
                values[2].length == 4 && values[3].length == 4;
    }


    @Override
    public Vector productMatrixOnVector(final Matrix m1, final Vector v1) {
        Vector vRes = new Vector4();
        float[] tmp = super.getMatrixAfterProductMatrixOnVector(m1, v1);
        vRes.setValues(tmp);
        return vRes;

    }
}