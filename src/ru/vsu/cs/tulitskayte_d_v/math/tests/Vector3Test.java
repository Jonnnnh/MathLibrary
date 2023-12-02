package ru.vsu.cs.tulitskayte_d_v.math.tests;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.tulitskayte_d_v.math.vector.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Vector3Test {
    @Test
    void testVectorProduct() {

        float[] vectorFirst = new float[]{-3.333f, 0.898f};
        float[] vectorSecond = new float[]{-4.21f, 2.34f, 1};
        Vector v1 = new Vector2(vectorFirst);
        Vector v2 = new Vector3(vectorSecond);
        Vector vRes = v1;
        v1.vectorCrossProduct(v2);
        assertArrayEquals(v1.getValues(), vRes.getValues());


        vectorFirst = new float[]{-3.333f, 0.898f};
        vectorSecond = new float[]{-4.21f, 2.34f};
        v1 = new Vector2(vectorFirst);
        v2 = new Vector2(vectorSecond);
        vRes = v1;
        v1.vectorCrossProduct(v2);
        assertArrayEquals(v1.getValues(), vRes.getValues());

        vectorFirst = new float[]{-3.333f, 0.898f, 1.87f};
        vectorSecond = new float[]{-4.21f, 2.34f, 0.22f};
        v1 = new Vector3(vectorFirst);
        v2 = new Vector3(vectorSecond);

        float[] expected = new float[]{-4.17824f, -7.13944f, -4.01864f};

        v1.vectorCrossProduct(v2);
        assertArrayEquals(expected, v1.getValues(), 0.000001f);
    }
}