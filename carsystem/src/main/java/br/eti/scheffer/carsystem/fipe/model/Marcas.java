package br.eti.scheffer.carsystem.fipe.model;

import java.io.Serializable;
import java.util.Objects;

public class Marcas implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1380170943624915404L;
	private String value;
    private String label;

    public Marcas() {
    }

    public Marcas(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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
        Marcas marcas = (Marcas) o;
        return value.equals(marcas.value) &&
                Objects.equals(label, marcas.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, label);
    }

    @Override
    public String toString() {
        return "Marcas{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
