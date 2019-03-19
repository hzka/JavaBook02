public class RationMartirx extends GenericMartix<Double> {
    @Override
    protected Double add(Double o1, Double o2) {
        return o1+o2;
    }

    @Override
    protected Double multiply(Double o1, Double o2) {
        return o1*o2;
    }

    @Override
    protected Double zero() {
        return (double) 0;
    }
}
