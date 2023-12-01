package ru.vsu.cs.tulitskayte_d_v.math.vector;

import ru.vsu.cs.tulitskayte_d_v.math.matrix.MathExceptions;

public class Vector4 extends NDimensionOfVector implements Vector {

    public Vector4() {
    }

    public Vector4(float[] values) {
        if (checkLengthInputValues(values)) {
            super.values = values;
            super.size = values.length;
        } else throw new MathExceptions();
    }

    public Vector4(float v1, float v2, float v3, float v4) {
        super.values = new float[4];

        super.size = 4;

        super.values[0] = v1;
        super.values[1] = v2;
        super.values[2] = v3;
        super.values[3] = v4;
    }

    @Override
    public void vectorCrossProduct(Vector v2) {
    }

    @Override
    public Vector vectorCrossProduct(Vector v1, Vector v2) {
        return null;
    }

    @Override
    protected boolean checkLengthInputValues(float[] values) {
        return values.length == 4;
    }
}
