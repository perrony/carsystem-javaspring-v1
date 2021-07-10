package br.eti.scheffer.carsystem.fipe.enums;

public enum TipoConsulta {
    TRADICIONAL(1),
    CODIGO(2);

    private Integer hierarchy;

    TipoConsulta(final Integer hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Integer getHierarchy() {
        return hierarchy;
    }
}
