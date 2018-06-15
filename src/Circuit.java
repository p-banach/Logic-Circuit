import java.util.ArrayList;

public class Circuit {

    // in this implementation, static-value input gates are connected
    // to the "throttleGate"
    // I1 I2 I3 I4
    //  |  | |  |
    //  \  | |  /
    //   \ | | /
    //    \| |/
    // (throttleGate)
    //  |  |  |  | (... further connections)
    //      ...
    //      ...
    //   finalGate

    private Gate throttleGate;
    private Gate finalGate;
    private ArrayList<Gate> inputGates;

    public Circuit(Gate finalGate, Gate throttleGate) {
        this.finalGate = finalGate;
        this.throttleGate = throttleGate;
        this.inputGates = new ArrayList<>();
    }

    public static void main(String[] args) {
        // NotGate is final, throttle is an OrGate
        Circuit circuit = new Circuit(new NotGate(), new OrGate()); //levels 2 and 5
        boolean[] startingGates = {true, false, false, true};       //level 1


        Gate level3_1 = new AndGate();
        Gate level3_2 = new AndGate();
        Gate level4_1 = new OrGate();

        circuit.connectGates(circuit.throttleGate, level3_1 );
        circuit.connectGates(circuit.throttleGate, level3_2 );
        circuit.connectGates(level3_1, level4_1 );
        circuit.connectGates(level3_2, level4_1 );
        circuit.connectGates(level4_1, circuit.finalGate);

        System.out.println(circuit.evaluate(startingGates)); // should be false

        System.out.println(circuit.inputLength());      // should be 4
        System.out.println(circuit.depth());            // should be 5
        System.out.println(circuit.size());             // should be 9
    }

    public void connectGates(Gate gateIn, Gate gateOut) {
        gateIn.addOutputGate(gateOut);
        gateOut.addInputGate(gateIn);
    }

    public int inputLength() {
        return inputGates.size();
    }

    public int size() {
        int tmp = sizeUtil(finalGate);
        // don't judge me
        resetWasCounted(finalGate);
        return tmp;
    }

    public int depth() {
        return depthUtil(finalGate);
    }

    public boolean evaluate(boolean[] input) {
        insertInputGates(input);
        return finalGate.getValue();
    }

    private int sizeUtil(Gate gate) {
        if (gate == null || gate.wasCounted)
            return 0;

        int result = 0;
        for (Gate inputGate : gate.getGatesIn()) {
            result += sizeUtil(inputGate);
        }
        gate.wasCounted = true;
        return result + 1;
    }

    private int depthUtil(Gate gate) {
        if (gate == null)
            return 0;

        int depth = 0;
        for (Gate inputGate : gate.getGatesIn()) {
            depth = Integer.max(depthUtil(inputGate), depth);
        }
        return depth + 1;
    }

    private void resetWasCounted(Gate gate) {
        if (gate == null)
            return;

        for (Gate inputGate : gate.getGatesIn()) {
            resetWasCounted(inputGate);
        }
        gate.wasCounted = false;
    }

    private void insertInputGates(boolean[] input) {
        for (boolean value : input) {
            Gate tmp = new InputGate(value);
            connectGates(tmp, throttleGate);
            inputGates.add(tmp);
        }
    }
}

