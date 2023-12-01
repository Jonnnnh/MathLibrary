package ru.vsu.cs.tulitskayte_d_v.math.vector;

import ru.vsu.cs.tulitskayte_d_v.math.matrix.MathExceptions;

public class Vector2 extends NDimensionOfVector implements Vector {

    public Vector2(float[] values) {
        super(2, values);
        if (!checkLengthInputValues(values)) {
            throw new MathExceptions();
        }
    }

    public Vector2(float v1, float v2) {
        super(2, new float[]{v1, v2});
    }

    public Vector2() {
        super(2, new float[2]);
    }

    @Override
    public void vectorCrossProduct(Vector v2) {
    }

    @Override
    public Vector vectorCrossProduct(Vector v1, Vector v2) {
        return new Vector3();
    }

    @Override
    protected boolean checkLengthInputValues(float[] values) {
        return values.length == 2;
    }
}
