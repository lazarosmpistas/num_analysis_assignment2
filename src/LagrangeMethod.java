public class LagrangeMethod {
    public static double LagrangeMethodResult(double[] x, double[] y, double xForFunction) {
        double[] L = new double[x.length];

        double PnFunctionSum = 0;
        for (int i = 0; i < L.length; i++) {
            L[i] = 1;
        }

        for (int j = 0; j < L.length; j++) {
            for (int i = 0; i < x.length; i++) {
                if(j != i) {
                    L[j] *= (xForFunction - x[i]) / (x[j] - x[i]);
                }
            }
        }

        for (int i = 0; i < L.length; i++) {
            PnFunctionSum += L[i] * y[i];
        }

        return PnFunctionSum;
    }
}
