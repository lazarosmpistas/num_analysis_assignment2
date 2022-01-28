public class ols {
    public static double olsMethod (double[] x, double[] y, double xPoint) {
        /**
         * a + bx = y
         * creating A matrix nx2 (first column a, second column b)
         * creating B matrix nx1 (column y)
         * creating AT matrix
         */

        int polynomialDegree = 3;
        double[][] A = new double[x.length][polynomialDegree];
        double[] B = new double[x.length];
        double[][] AT = new double[polynomialDegree][x.length];
        for (int i = 0; i < x.length; i++) {
            A[i][polynomialDegree-3] = 1;
            A[i][polynomialDegree-2] = x[i];
            A[i][polynomialDegree-1] = Math.pow(x[i], 2);

            B[i] = y[i];

            AT[polynomialDegree-3][i] = 1;
            AT[polynomialDegree-2][i] = x[i];
            AT[polynomialDegree-1][i] = Math.pow(x[i], 2);
        }
        /**
         * multiplying with AT
         */

        double[][] ATA = new double[polynomialDegree][polynomialDegree];
        for (int i = 0; i < polynomialDegree; i++) {
            for (int j = 0; j < polynomialDegree; j++) {
                ATA[i][j] = 0;
            }
        }
        for (int i = 0; i < polynomialDegree; i++) {
            for (int j = 0; j < polynomialDegree; j++) {
                for (int k = 0; k < x.length; k++) {
                    ATA[i][j] += AT[i][k] * A[k][j];
                }
            }
        }


        double[] ATB = new double[polynomialDegree];
        for (int i = 0; i < polynomialDegree; i++) {
            ATB[i]  = 0;
        }
        for (int i = 0; i < polynomialDegree; i++) {
            for (int j = 0; j < x.length; j++) {
                ATB[i] += AT[i][j] * B[j];
            }
        }

        /**
         * solving the equation ATAx = ATb (x1 = a, x2 = b, x3 = c), creating a 2nd degree polynomial a + bx + cx^2 = y, replacing x with xPoint
         * and returning y
         */
        double a, b, c, detMatrix1, detMatrix2, detMatrix3, detMatrix, detA1, detA2, detA3, detA, detB1, detB2, detB3, detB, detC1, detC2, detC3, detC;
        detMatrix1 = ATA[1][1] * ATA[2][2] - ATA[2][1] * ATA[1][2];
        detMatrix2 = ATA[1][0] * ATA[2][2] - ATA[2][0] * ATA[1][2];
        detMatrix3 = ATA[1][0] * ATA[2][1] - ATA[2][0] * ATA[1][1];
        detMatrix = ATA[0][0] * detMatrix1 - ATA[0][1] * detMatrix2 + ATA[0][2] * detMatrix3;

        detA1 = ATA[1][1] * ATA[2][2] - ATA[2][1] * ATA[1][2];
        detA2 = ATB[1] * ATA[2][2] - ATB[2] * ATA[1][2];
        detA3 = ATB[1] * ATA[2][1] - ATB[2] * ATA[1][1];
        detA = ATB[0] * detA1 - ATA[0][1] * detA2 + ATA[0][2] * detA3;

        detB1 = ATB[1] * ATA[2][2] - ATB[2] * ATA[1][2];
        detB2 = ATA[1][0] * ATA[2][2] - ATA[2][0] * ATA[1][2];
        detB3 = ATA[1][0] * ATB[2] - ATA[2][0] * ATB[1];
        detB = ATA[0][0] * detB1 - ATB[0] * detB2 + ATA[0][2] * detB3;

        detC1 = ATA[1][1] * ATB[2] - ATA[2][1] * ATB[1];
        detC2 = ATA[1][0] * ATB[2] - ATA[2][0] * ATB[1];
        detC3 = ATA[1][0] * ATA[2][1] - ATA[2][0] * ATA[1][1];
        detC = ATA[0][0] * detC1 - ATA[0][1] * detC2 + ATB[0] * detC3;

        a = detA / detMatrix;
        b = detB / detMatrix;
        c = detC / detMatrix;
        /*
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
         */
        return a + b*xPoint + c * Math.pow(xPoint, 2);
    }

}
