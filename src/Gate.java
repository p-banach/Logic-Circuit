import java.util.ArrayList;

public abstract class Gate {

    // I know this one is lazy
    public boolean wasCounted;
    protected Boolean value;

    private int possibleNumberOfGatesIn;
    private int possibleNumberOfGatesOut;

    private ArrayList<Gate> gatesIn;
    private ArrayList<Gate> gatesOut;

    public Gate(int possibleNumberOfGatesIn, int possibleNumberOfGatesOut) {
        this.possibleNumberOfGatesIn = possibleNumberOfGatesIn;
        this.possibleNumberOfGatesOut = possibleNumberOfGatesOut;
        gatesIn = new ArrayList<>();
        gatesOut = new ArrayList<>();
        value = null;
        wasCounted = false;
    }

    public ArrayList<Gate> getGatesIn() {
        return gatesIn;
    }

    public ArrayList<Gate> getGatesOut() {
        return gatesOut;
    }

    public void addInputGate(Gate gate) {
        if (gatesIn.size() < possibleNumberOfGatesIn)
            gatesIn.add(gate);
    }

    public void addOutputGate(Gate gate) {
        if (gatesIn.size() < possibleNumberOfGatesOut)
            gatesOut.add(gate);
    }

    public boolean getValue() {
        if (value == null)
            calculateValue();

        return value;
    }

    public abstract void calculateValue();
}
