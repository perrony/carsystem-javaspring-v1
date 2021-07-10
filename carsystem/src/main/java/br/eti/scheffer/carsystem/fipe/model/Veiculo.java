package br.eti.scheffer.carsystem.fipe.model;

public class Veiculo {
    private int anoModelo;
    private String CodigoFipe;
    private String Combustivel;
    private String DataConsulta;
    private String Marca;
    private String MesReferencia;
    private String Modelo;
    private String SiglaCombustivel;
    private int TipoVeiculo;
    private String Valor;

    public Veiculo() {
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCodigoFipe() {
        return CodigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        CodigoFipe = codigoFipe;
    }

    public String getCombustivel() {
        return Combustivel;
    }

    public void setCombustivel(String combustivel) {
        Combustivel = combustivel;
    }

    public String getDataConsulta() {
        return DataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        DataConsulta = dataConsulta;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getMesReferencia() {
        return MesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        MesReferencia = mesReferencia;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getSiglaCombustivel() {
        return SiglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        SiglaCombustivel = siglaCombustivel;
    }

    public int getTipoVeiculo() {
        return TipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        TipoVeiculo = tipoVeiculo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "anoModelo='" + anoModelo + '\'' +
                ", CodigoFipe='" + CodigoFipe + '\'' +
                ", Combustivel='" + Combustivel + '\'' +
                ", DataConsulta='" + DataConsulta + '\'' +
                ", Marca='" + Marca + '\'' +
                ", MesReferencia='" + MesReferencia + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", SiglaCombustivel='" + SiglaCombustivel + '\'' +
                ", TipoVeiculo=" + TipoVeiculo +
                ", Valor='" + Valor + '\'' +
                '}';
    }
}
