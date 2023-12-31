package ru.vsu.cs.tulitskayte_d_v.math.vector;

import ru.vsu.cs.tulitskayte_d_v.math.matrix.MathExceptions;

public class Vector3 extends NDimensionOfVector implements Vector {

    public Vector3() {
        super(3, new float[3]);
    }

    public Vector3(Vector3 v){
        super(3, v.getValues().clone());
    }
    public Vector3(float[] values) {
        super(3, values); // Используем базовый конструктор для инициализации
        if (!checkLengthInputValues(values)) {
            throw new MathExceptions();
        }
    }

    public Vector3(float v1, float v2, float v3) {
        super(3, new float[]{v1, v2, v3});
    }

    public void vectorCrossProduct(Vector v2) {
        Vector3 vRes = new Vector3();
        float[] tmp = new float[3];
        if (this.getSize() != v2.getSize() || !checkLengthInputValues(this.getValues())
                || !checkLengthInputValues(v2.getValues())) {
            throw new MathExceptions();
        }

        tmp[0] = this.getValues()[1] * v2.getValues()[2] - this.getValues()[2] * v2.getValues()[1];
        tmp[1] = -(this.getValues()[0] * v2.getValues()[2] - this.getValues()[2] * v2.getValues()[0]);
        tmp[2] = this.getValues()[0] * v2.getValues()[1] - this.getValues()[1] * v2.getValues()[0];
        vRes.setValues(tmp);

        this.values = vRes.values;
        this.size = vRes.size;
    }

    public Vector vectorCrossProduct(Vector v1, Vector v2) {

        float[] tmp = new float[3];
        if (v1.getSize() != v2.getSize() && !checkLengthInputValues(v1.getValues())
                && !checkLengthInputValues(v2.getValues())) {
            throw new MathExceptions();
        }
        tmp[0] = v1.getValues()[1] * v2.getValues()[2] - v1.getValues()[2] * v2.getValues()[1];
        tmp[1] = -(v1.getValues()[0] * v2.getValues()[2] - v1.getValues()[2] * v2.getValues()[0]);
        tmp[2] = v1.getValues()[0] * v2.getValues()[1] - v1.getValues()[1] * v2.getValues()[0];

        this.setValues(tmp);
        this.size = tmp.length;
        return this;
    }

    @Override
    protected boolean checkLengthInputValues(float[] values) {
        return values.length == 3;
    }
}