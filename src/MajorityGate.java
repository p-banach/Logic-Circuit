public class MajorityGate extends Gate {
    public MajorityGate() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public void calculateValue() {
        int positive_gates = 0;
        int negative_gates = 0;

        for (Gate gate : getGatesIn()) {

            if (gate.getValue())
                positive_gates++;
            else
                negative_gates++;
        }
        // self-explanatory
        value = (positive_gates > negative_gates);
    }
}
