package ru.vsu.cs.tulitskayte_d_v.math.vector;

import ru.vsu.cs.tulitskayte_d_v.math.matrix.MathExceptions;

public class Vector2 extends NDimensionOfVector implements Vector {

    public Vector2(float[] values) {
        if (checkLengthInputValues(values)) {
            super.values = values;
            super.size = values.length;
        } else throw new MathExceptions();
    }

    public Vector2(float v1, float v2) {
        super.values = new float[2];

        super.size = 2;

        super.values[0] = v1;
        super.values[1] = v2;
    }

    public Vector2() {
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
