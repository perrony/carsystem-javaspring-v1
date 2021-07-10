package br.eti.scheffer.carsystem.fipe.model;

import java.io.Serializable;
import java.util.Objects;

public class Modelos implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7167788659625935230L;
	private int value;
    private String label;

    public Modelos() {
    }

    public Modelos(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modelos modelos = (Modelos) o;
        return value == modelos.value &&
                Objects.equals(label, modelos.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, label);
    }

    @Override
    public String toString() {
        return "Modelos{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
