public class InputGate extends Gate {

    InputGate(Boolean value) {
        super(0, Integer.MAX_VALUE);
        this.value = value;
    }

    @Override
    public void addInputGate(Gate gate) {
        System.out.println("Can't add input to an InputGate!");
    }

    @Override
    public void calculateValue() {

    }
}

