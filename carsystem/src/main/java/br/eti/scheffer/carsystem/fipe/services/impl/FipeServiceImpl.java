package br.eti.scheffer.carsystem.fipe.services.impl;



import br.eti.scheffer.carsystem.fipe.enums.TipoConsulta;
import br.eti.scheffer.carsystem.fipe.enums.TipoVeiculo;
import br.eti.scheffer.carsystem.fipe.model.*;
import br.eti.scheffer.carsystem.fipe.services.FipeService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FipeServiceImpl implements FipeService {


    @Override
    public List<Referencia> listReferencia() {

        try (CloseableHttpClient client = HttpClients.custom().build()) {
            HttpUriRequest request = RequestBuilder.post()
                    .setUri("https://veiculos.fipe.org.br/api/veiculos//ConsultarTabelaDeReferencia")
                    .setHeader("CONTENT_TYPE", "application/json")
                    .setHeader("Content-Length", "0")
                    .build();
            final CloseableHttpResponse execute = client.execute(request);
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                JSONArray jsonArr = new JSONArray(EntityUtils.toString(entity));
                List<Referencia> referenciaList = new ArrayList<>();
                for (int i = 0; i < jsonArr.length(); i++) {
                    JSONObject jsonObj = jsonArr.getJSONObject(i);
                    Referencia data = new Referencia();
                    data.setCodigo(jsonObj.getInt("Codigo"));
                    data.setMes(jsonObj.getString("Mes"));
                    referenciaList.add(data);
                }
                return referenciaList;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Marcas> listMarcas(String codigoTipoVeiculo,
                                   String codigoTabelaReferencia
    ) {
        try (CloseableHttpClient client = HttpClients.custom().build()) {
            HttpUriRequest request = RequestBuilder.post()
                    .setUri("https://veiculos.fipe.org.br/api/veiculos//ConsultarMarcas")
                    .setHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .addParameter("codigoTabelaReferencia", codigoTabelaReferencia)
                    .addParameter("codigoTipoVeiculo", codigoTipoVeiculo)
                    .build();

            final CloseableHttpResponse execute = client.execute(request);
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                JSONArray jsonArr = new JSONArray(EntityUtils.toString(entity));
                List<Marcas> marcasList = new ArrayList<>();
                for (int i = 0; i < jsonArr.length(); i++) {
                    JSONObject jsonObj = jsonArr.getJSONObject(i);
                    Marcas data = new Marcas(jsonObj.getString("Value"), jsonObj.getString("Label"));
                    marcasList.add(data);
                }
                return marcasList;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Modelos> listModelos(String codigoTipoVeiculo,
                                     String codigoTabelaReferencia,
                                     String codigoMarca) {
        try (CloseableHttpClient client = HttpClients.custom().build()) {
            HttpUriRequest request = RequestBuilder.post()
                    .setUri("https://veiculos.fipe.org.br/api/veiculos//ConsultarModelos")
                    .setHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .addParameter("codigoTipoVeiculo", codigoTipoVeiculo)
                    .addParameter("codigoTabelaReferencia", codigoTabelaReferencia)
                    .addParameter("codigoMarca", codigoMarca)
                    .build();
            final CloseableHttpResponse execute = client.execute(request);
            HttpEntity entity = execute.getEntity();
            String content = EntityUtils.toString(entity);
            content = content.substring(content.indexOf('['), content.length() - 1);

            if (entity != null) {
                JSONArray jsonArr = new JSONArray(content);
                List<Modelos> modelosList = new ArrayList<>();
                for (int i = 0; i < jsonArr.length(); i++) {
                    JSONObject jsonObj = jsonArr.getJSONObject(i);
                    Modelos data = new Modelos(jsonObj.getInt("Value"), jsonObj.getString("Label"));
                    modelosList.add(data);
                }
                return modelosList;


            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<AnoModelo> listAnoModelo(String codigoTipoVeiculo,
                                         String codigoTabelaReferencia,
                                         String codigoMarca,
                                         String codigoModelo) {
        try (CloseableHttpClient client = HttpClients.custom().build()) {
            HttpUriRequest request = RequestBuilder.post()
                    .setUri("https://veiculos.fipe.org.br/api/veiculos//ConsultarAnoModelo")
                    .setHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .addParameter("codigoTipoVeiculo", codigoTipoVeiculo)
                    .addParameter("codigoTabelaReferencia", codigoTabelaReferencia)
                    .addParameter("codigoModelo", codigoModelo)
                    .addParameter("codigoMarca", codigoMarca)
                    .build();
            final CloseableHttpResponse execute = client.execute(request);
            HttpEntity entity = execute.getEntity();
            String content = EntityUtils.toString(entity);


            if (entity != null) {
                JSONArray jsonArr = new JSONArray(content);
                List<AnoModelo> anoModeloList = new ArrayList<>();
                for (int i = 0; i < jsonArr.length(); i++) {
                    JSONObject jsonObj = jsonArr.getJSONObject(i);
                    AnoModelo data = new AnoModelo(jsonObj.getString("Value"), jsonObj.getString("Label"));
                    anoModeloList.add(data);
                }
                return anoModeloList;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<AnoModelo> listaModeloEAno(String codigoTipoVeiculo,
                                           String codigoTabelaReferencia,
                                           String codigoMarca,
                                           String codigoModelo,
                                           String ano) {
        try (CloseableHttpClient client = HttpClients.custom().build()) {
            HttpUriRequest request = RequestBuilder.post()
                    .setUri("https://veiculos.fipe.org.br/api/veiculos//ConsultarModelosAtravesDoAno")
                    .setHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .addParameter("codigoTipoVeiculo", codigoTipoVeiculo)
                    .addParameter("codigoTabelaReferencia", codigoTabelaReferencia)
                    .addParameter("codigoModelo", codigoModelo)
                    .addParameter("codigoMarca", codigoMarca)
                    .addParameter("ano", ano)
                    .addParameter("codigoTipoCombustivel", ano.substring(5))
                    .addParameter("anoModelo", ano.substring(0, 4))
                    .build();
            final CloseableHttpResponse execute = client.execute(request);
            HttpEntity entity = execute.getEntity();
            String content = EntityUtils.toString(entity);

            if (entity != null) {
                JSONArray jsonArr = new JSONArray(content);
                List<AnoModelo> anoModeloList = new ArrayList<>();
                for (int i = 0; i < jsonArr.length(); i++) {
                    JSONObject jsonObj = jsonArr.getJSONObject(i);
                    AnoModelo data = new AnoModelo(jsonObj.getString("Value"), jsonObj.getString("Label"));
                    anoModeloList.add(data);
                }
                return anoModeloList;
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Veiculo findVeiculo(String codigoTipoVeiculo,
                               String codigoTabelaReferencia,
                               String codigoMarca,
                               String codigoModelo,
                               String ano,
                               String tipoConsulta) {


        try (CloseableHttpClient client = HttpClients.custom().build()) {
            HttpUriRequest request = RequestBuilder.post()
                    .setUri("https://veiculos.fipe.org.br/api/veiculos//ConsultarValorComTodosParametros")
                    .setHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .addParameter("codigoTabelaReferencia", codigoTabelaReferencia)
                    .addParameter("codigoMarca", codigoMarca)
                    .addParameter("codigoModelo", codigoModelo)
                    .addParameter("codigoTipoVeiculo", codigoTipoVeiculo)
                    .addParameter("anoModelo", ano.substring(0, 4))
                    .addParameter("codigoTipoCombustivel", ano.substring(5))
                    .addParameter("tipoVeiculo", findTipoVeiculo(codigoTipoVeiculo))
                    .addParameter("tipoConsulta", findTipoConsulta(tipoConsulta))
                    .build();
            final CloseableHttpResponse execute = client.execute(request);
            HttpEntity entity = execute.getEntity();
            String content = "[" + EntityUtils.toString(entity) + "]";
            if (entity != null) {
                JSONArray jsonArr = new JSONArray(content);
                Veiculo veiculo = new Veiculo();
                JSONObject jsonObj = jsonArr.getJSONObject(0);
                veiculo.setValor(jsonObj.getString("Valor"));
                veiculo.setMarca(jsonObj.getString("Marca"));
                veiculo.setModelo(jsonObj.getString("Modelo"));
                veiculo.setAnoModelo(jsonObj.getInt("AnoModelo"));
                veiculo.setCombustivel(jsonObj.getString("Combustivel"));
                veiculo.setCodigoFipe(jsonObj.getString("CodigoFipe"));
                veiculo.setMesReferencia(jsonObj.getString("MesReferencia"));
                veiculo.setTipoVeiculo(jsonObj.getInt("TipoVeiculo"));
                veiculo.setSiglaCombustivel(jsonObj.getString("SiglaCombustivel"));
                veiculo.setDataConsulta(jsonObj.getString("DataConsulta"));

                return veiculo;
            }
            return null;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<VeiculoAnoCombustivel> findVeiculoCodigoFipe(String codigoTipoVeiculo, String codigoTabelaReferencia, String modeloCodigoExterno) {
        try (CloseableHttpClient client = HttpClients.custom().build()) {
            HttpUriRequest request = RequestBuilder.post()
                    .setUri("https://veiculos.fipe.org.br/api/veiculos//ConsultarAnoModeloPeloCodigoFipe")
                    .setHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .addParameter("codigoTipoVeiculo", codigoTipoVeiculo)
                    .addParameter("codigoTabelaReferencia", codigoTabelaReferencia)
                    .addParameter("modeloCodigoExterno", modeloCodigoExterno)
                    .build();
            final CloseableHttpResponse execute = client.execute(request);
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                String content = EntityUtils.toString(entity);
                JSONArray jsonArr = new JSONArray(content);
                List<VeiculoAnoCombustivel> anoCombustivelList = new ArrayList<>();
                for (int i = 0; i < jsonArr.length(); i++) {
                    JSONObject jsonObj = jsonArr.getJSONObject(i);
                    VeiculoAnoCombustivel data = new VeiculoAnoCombustivel();
                    data.setLabel(jsonObj.getString("Label"));
                    data.setValue(jsonObj.getString("Value"));
                    data.setTipoCombustivel(Integer.parseInt(data.getValue().substring(5)));
                    data.setAno(Integer.parseInt(data.getValue().substring(0, 4)));
                    anoCombustivelList.add(data);
                }
                return anoCombustivelList;

            }
            return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String findTipoVeiculo(String tipo) {
        Integer num = Integer.parseInt(tipo);
        if (num == TipoVeiculo.CARRO.getHierarchy()) {
            return TipoVeiculo.CARRO.toString().toLowerCase();
        } else if (num == TipoVeiculo.MOTO.getHierarchy()) {
            return TipoVeiculo.MOTO.toString().toLowerCase();
        } else if (num == TipoVeiculo.CAMINHAO.getHierarchy()) {
            return TipoVeiculo.CAMINHAO.toString().toLowerCase();
        }
        return null;
    }

    public String findTipoConsulta(String tipoConsulta) {
        Integer num = Integer.parseInt(tipoConsulta);
        if (num == TipoConsulta.TRADICIONAL.getHierarchy()) {
            return TipoConsulta.TRADICIONAL.toString().toLowerCase();
        } else if (num == TipoConsulta.CODIGO.getHierarchy()) {
            return TipoConsulta.CODIGO.toString().toLowerCase();
        }
        return null;
    }
}
