package br.eti.scheffer.carsystem.fipe.enums;

public enum TipoVeiculo {
    CARRO(1),
    MOTO(2),
    CAMINHAO(3);

    private Integer hierarchy;

    TipoVeiculo(final Integer hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Integer getHierarchy() {
        return hierarchy;
    }

}
