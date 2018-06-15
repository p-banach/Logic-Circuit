public class NotGate extends Gate {

    public NotGate() {
        // you can only negate one input
        super(1, Integer.MAX_VALUE);
    }

    @Override
    public void calculateValue() {
        value = !getGatesIn().get(0).getValue();
    }

}
