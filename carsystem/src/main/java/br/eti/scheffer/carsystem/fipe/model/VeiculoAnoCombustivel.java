package br.eti.scheffer.carsystem.fipe.model;

import java.util.Objects;

public class VeiculoAnoCombustivel {
    private String value;
    private String label;
    private int tipoCombustivel;
    private int ano;

    public VeiculoAnoCombustivel(String value, String label, int tipoCombustivel, int ano) {
        this.value = value;
        this.label = label;
        this.tipoCombustivel = tipoCombustivel;
        this.ano = ano;
    }

    public VeiculoAnoCombustivel() {
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

    public int getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(int tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoAnoCombustivel that = (VeiculoAnoCombustivel) o;
        return tipoCombustivel == that.tipoCombustivel &&
                ano == that.ano &&
                value.equals(that.value) &&
                label.equals(that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, label, tipoCombustivel, ano);
    }

    @Override
    public String toString() {
        return "VeiculoAnoCombustivel{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", tipoCombustivel=" + tipoCombustivel +
                ", ano=" + ano +
                '}';
    }
}
