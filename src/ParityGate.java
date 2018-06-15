public class ParityGate extends Gate {

    public ParityGate() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public void calculateValue() {
        int positive_gates = 0;

        for (Gate gate : getGatesIn()) {

            if (gate.getValue())
                positive_gates++;
        }

        // self-explanatory
        value = (positive_gates % 2 == 1);
    }


}
