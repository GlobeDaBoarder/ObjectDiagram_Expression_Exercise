package at.fhj.swd;

public class Number implements Expression {
    private float value = 0;

    public Number(float value) {
        setValue(value);
    }

    public Number(Number number) {
        if (number == null)
            throw new IllegalArgumentException("Value can't be null");
        setValue(number.getValue());
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float evaluate() {
        return getValue();
    }

}
