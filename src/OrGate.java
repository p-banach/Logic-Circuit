public class OrGate extends Gate {

    public OrGate() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public void calculateValue() {
        boolean result = false;

        for (Gate gate : getGatesIn()) {
            result = gate.getValue();

            if (result)
                break;
        }

        value = result;
    }

}
