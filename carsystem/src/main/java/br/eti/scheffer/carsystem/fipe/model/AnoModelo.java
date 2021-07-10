package br.eti.scheffer.carsystem.fipe.model;

import java.util.Objects;

public class AnoModelo {
    private String value;
    private String label;

    public AnoModelo(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public AnoModelo() {
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
        AnoModelo anoModelo = (AnoModelo) o;
        return value.equals(anoModelo.value) &&
                Objects.equals(label, anoModelo.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, label);
    }

    @Override
    public String toString() {
        return "AnoModelo{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
