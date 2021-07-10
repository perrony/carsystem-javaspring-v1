package br.eti.scheffer.carsystem.fipe.services;



import br.eti.scheffer.carsystem.fipe.model.*;

import java.util.List;

public interface FipeService {

    List<Referencia> listReferencia();

    List<Marcas> listMarcas(String codigoTipoVeiculo, String codigoTabelaReferencia);

    List<Modelos> listModelos(String codigoTipoVeiculo,
                              String codigoTabelaReferencia,
                              String codigoMarca);


    List<AnoModelo> listAnoModelo(String codigoTipoVeiculo,
                                  String codigoTabelaReferencia,
                                  String codigoMarca,
                                  String codigoModelo);

    List<AnoModelo> listaModeloEAno(String codigoTipoVeiculo,
                                    String codigoTabelaReferencia,
                                    String codigoMarca,
                                    String codigoModelo,
                                    String ano);


    Veiculo findVeiculo(String codigoTipoVeiculo,
                        String codigoTabelaReferencia,
                        String codigoMarca,
                        String codigoModelo,
                        String ano,
                        String tipoConsulta);

    List<VeiculoAnoCombustivel> findVeiculoCodigoFipe(String codigoTipoVeiculo,
                                                      String codigoTabelaReferencia,
                                                      String modeloCodigoExterno);


}
