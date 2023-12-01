package ru.vsu.cs.tulitskayte_d_v.math.vector;

import ru.vsu.cs.tulitskayte_d_v.math.matrix.MathExceptions;

public class Vector4 extends NDimensionOfVector implements Vector {

    public Vector4() {
        super(4, new float[4]);
    }

    public Vector4(float[] values) {
        super(4, values);
        if (!checkLengthInputValues(values)) {
            throw new MathExceptions();
        }
    }

    public Vector4(float v1, float v2, float v3, float v4) {
        super(4, new float[]{v1, v2, v3, v4});
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
