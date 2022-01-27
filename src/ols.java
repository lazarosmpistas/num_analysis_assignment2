public class ols {
    public static double olsMethod (double x) {
        System.out.println("FOR X = {-2π, -3π/2, -π, -π/2, 0, π/2, π, 3π/2, 2π, 5π/2} THE OLS METHOD RETURNS THE FUNCTION" +
                "\"y = 0.09696 + 0.00385x\nTHE VALUE OF SIN(X) IS CALCULATED AT:");
        return (0.00385 * x) +0.09696;
    }

}
