package br.eti.scheffer.carsystem.fipe.model;

import java.io.Serializable;

public class Referencia implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2167789741241775012L;
	private int Codigo;
    private String Mes;

    public Referencia() {
    }

    public Referencia(int codigo, String mes) {
        Codigo = codigo;
        Mes = mes;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String mes) {
        Mes = mes;
    }

    @Override
    public String toString() {
        return "Referencia{" +
                "Codigo=" + Codigo +
                ", Mes='" + Mes + '\'' +
                '}';
    }
}
