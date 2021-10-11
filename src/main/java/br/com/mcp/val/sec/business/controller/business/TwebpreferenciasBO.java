package br.com.mcp.val.sec.business.controller.business;

import br.com.core.exception.NegocioException;
import br.com.core.message.MensagemLista;
import br.com.core.resource.ResourceServiceUtil;
import br.com.core.util.CriptografiaUtil;
import br.com.core.util.DateUtil;
import br.com.core.util.ManifestUtil;
import br.com.core.util.NumberUtil;
import br.com.core.util.ObjectUtil;
import br.com.core.util.ServiceUtil;
import com.core.spring.boot.EncrytedUtils;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import br.com.mcp.val.sec.business.controller.business.interfaces.Twebpreferencias;
import br.com.mcp.val.sec.business.controller.business.interfaces.Twebpreferencias.TwebpreferenciasAmbiente;
import br.com.mcp.val.sec.business.controller.business.interfaces.Twebpreferencias.TwebpreferenciasScheduler;
import br.com.mcp.val.sec.entity.TwebpreferenciasTO;
import br.com.mcp.val.sec.entity.persistence.TwebpreferenciasPO;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>Classe:</b> TwebpreferenciasBO <br>
 * <b>Descrição:</b>     <br>
 *
 * <b>Projeto:</b> cifarma-entity <br>
 * <b>Pacote:</b> br.com.cifarma.entity.business.controller.business <br>
 * <b>Empresa:</b> Cifarma - Científica Farmacêutica LTDA. <br>
 *
 * Copyright (c) 2017 CIFARMA - Todos os direitos reservados.
 *
 * @author marce
 * @version Revision: $$ Date: 05/06/2017
 */
@Service
public class TwebpreferenciasBO implements Twebpreferencias {

    @Autowired
    TwebpreferenciasPO persistencia;

    /*@Autowired
    Twebsrvprocess serviceProcessNegocio;*/
    @Override
    public TwebpreferenciasTO alterar(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        antesDeAlterar(twebpreferenciasTO);
        return this.persistencia.alterar(twebpreferenciasTO);
    }

    @Override
    public TwebpreferenciasTO alterar(TwebpreferenciasTO twebpreferenciasTO, List<String> naoUsarServidorProxy) throws NegocioException {
        antesDeAlterar(twebpreferenciasTO);
        if (naoUsarServidorProxy != null
                && !naoUsarServidorProxy.isEmpty()) {
            twebpreferenciasTO.setNaoUsarServidorProxy(String.join("|", naoUsarServidorProxy));
        }
        return this.persistencia.alterar(twebpreferenciasTO);
    }

    private void antesDeAlterar(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        twebpreferenciasTO.setSenhaAcessoCompartilhado(CriptografiaUtil.encryptBase64(twebpreferenciasTO.getSenhaAcessoCompartilhado()));
        twebpreferenciasTO.setCorreiosSenhaLr(CriptografiaUtil.encryptBase64(twebpreferenciasTO.getCorreiosSenhaLr()));
        twebpreferenciasTO.setCorreiosSenhaWs(CriptografiaUtil.encryptBase64(twebpreferenciasTO.getCorreiosSenhaWs()));

        if (twebpreferenciasTO.getMicroServicos() != null
                && !twebpreferenciasTO.getMicroServicos().isBlank()) {
            Pattern pattern = Pattern.compile(TwebpreferenciasPattern.URI_MICRO_SERVICOS.getPattern(), Pattern.CASE_INSENSITIVE);
            ServiceUtil.isValidURI(twebpreferenciasTO.getMicroServicos(), pattern);
        }
    }

    private void antesDeExcluir(TwebpreferenciasTO twebpreferenciasTO) {
    }

    private void antesDeIncluir(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
    }

    @Override
    public TwebpreferenciasTO consultar(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        TwebpreferenciasTO preferencias = this.persistencia.consultar(twebpreferenciasTO);
        ObjectUtil.verificarCamposNulos(preferencias).orElseThrow(() -> new NegocioException("preferenciasSistemaNaoConfigurada"));
        if (preferencias.getSenhaAcessoCompartilhado() != null
                && !preferencias.getSenhaAcessoCompartilhado().isBlank()) {
            preferencias.setSenhaAcessoCompartilhado(CriptografiaUtil.decryptBase64(preferencias.getSenhaAcessoCompartilhado()));
        }
        if (preferencias.getCorreiosSenhaWs() != null
                && !preferencias.getCorreiosSenhaWs().isBlank()) {
            preferencias.setCorreiosSenhaWs(CriptografiaUtil.decryptBase64(preferencias.getCorreiosSenhaWs()));
        }
        if (preferencias.getCorreiosSenhaLr() != null
                && !preferencias.getCorreiosSenhaLr().isBlank()) {
            preferencias.setCorreiosSenhaLr(CriptografiaUtil.decryptBase64(preferencias.getCorreiosSenhaLr()));
        }
        if (!validarLicenca(preferencias)) {
            throw new NegocioException("lincecaNaoMaisValidaOuExpirada");
        }
        return preferencias;
    }

    @Override
    public LocalDateTime consultarDataAtual() throws NegocioException {
        return this.persistencia.getLocalDateTimeToOracle();
    }

    @Override
    public void excluir(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        antesDeExcluir(twebpreferenciasTO);
        this.persistencia.excluir(twebpreferenciasTO);
    }

    @Override
    public void incluir(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        antesDeIncluir(twebpreferenciasTO);
        this.persistencia.incluir(twebpreferenciasTO);
    }

    @Override
    public void incluir(TwebpreferenciasTO twebpreferenciasTO, List<String> naoUsarServidorProxy) throws NegocioException {
        antesDeIncluir(twebpreferenciasTO);
        if (naoUsarServidorProxy != null
                && !naoUsarServidorProxy.isEmpty()) {
            twebpreferenciasTO.setNaoUsarServidorProxy(String.join("|", naoUsarServidorProxy));
        }
        this.persistencia.incluir(twebpreferenciasTO);
    }

    @Override
    public List<TwebpreferenciasTO> listar(TwebpreferenciasTO twebpreferenciasTO) {
        return this.persistencia.listar(twebpreferenciasTO);
    }

    @Override
    public String[] retornaTempoExecucaoScheduler(TwebpreferenciasTO twebpreferenciasTO, TwebpreferenciasScheduler scheduler, long tempoDeInatividade) throws NegocioException {
        if (twebpreferenciasTO == null || twebpreferenciasTO.getId() == null) {
            throw new NegocioException("preferenciasSistemaNaoConfigurada");
        }
        if (scheduler == null) {
            throw new NegocioException("informeTipoSchedulerDesejado");
        }
        String horaSemAtualizacao = "";
        String diaSemAtualizacao = "";
        String minutosSemAtualizacao = "";
        LocalDateTime horaAtual;
        LocalDateTime horaFinal;
        Duration duration = Duration.ZERO;
        //verfica scheduler correios
        if (scheduler.equals(TwebpreferenciasScheduler.CORREIOS) && twebpreferenciasTO.getUltimoRetornoCorreios() != null) {
            horaAtual = DateUtil.asLocalDateTime(new Date());
            horaFinal = DateUtil.asLocalDateTime(twebpreferenciasTO.getUltimoRetornoCorreios());
            duration = Duration.between(horaFinal, horaAtual);
        }
        //verfica e-mail site cifarma
        if (scheduler.equals(TwebpreferenciasScheduler.E_MAIL) && twebpreferenciasTO.getUltimoEmailSiteCifarma() != null) {
            horaAtual = DateUtil.asLocalDateTime(new Date());
            horaFinal = DateUtil.asLocalDateTime(twebpreferenciasTO.getUltimoEmailSiteCifarma());
            duration = Duration.between(horaFinal, horaAtual);
        }
        if (duration.isZero()) {
            return null;
        }
        if (duration.toDaysPart() > 0) {
            diaSemAtualizacao = diaSemAtualizacao
                    .concat(String.valueOf(duration.toDaysPart()))
                    .concat(" ")
                    .concat(ResourceServiceUtil.getMessageResourceString("diaOuDias", null)
                            .concat(duration.toHoursPart() > 0 ? ", " : ""));
        }
        if (duration.toHoursPart() > 0) {
            horaSemAtualizacao = horaSemAtualizacao
                    .concat(String.valueOf(duration.toHoursPart()))
                    .concat(" ")
                    .concat(ResourceServiceUtil.getMessageResourceString("horaOuHoras", null));
        }
        if (duration.toMinutesPart() > 0) {
            minutosSemAtualizacao = minutosSemAtualizacao.concat(horaSemAtualizacao.isBlank() ? "" : " e ")
                    .concat(String.valueOf(duration.toMinutesPart()))
                    .concat(" ")
                    .concat(ResourceServiceUtil.getMessageResourceString("minutoOuMinutos", null));
        }
        if (duration.toHoursPart() > 0 || duration.toDaysPart() > 0 || duration.toMinutesPart() > tempoDeInatividade) {
            return new String[]{diaSemAtualizacao, horaSemAtualizacao, minutosSemAtualizacao};
        }
        return null;
    }

    @Override
    public TwebpreferenciasTO validarAcesso(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        MensagemLista mensagemLista = new MensagemLista();
        if (twebpreferenciasTO == null) {
            throw new NegocioException("preferenciasSistemaNaoConfigurada");
        }
        if (twebpreferenciasTO.getVersaoAtual() == null) {
            throw new NegocioException("versaoAtualDoSistemaNaoInformada");
        }
        if (twebpreferenciasTO.getAmbiente() == null) {
            throw new NegocioException("ambienteDoSistemaNaoInformada");
        }
        if (!twebpreferenciasTO.getAmbiente().equals(TwebpreferenciasAmbiente.HOMOLOGACAO.getAmbiente()) && !ManifestUtil.getImplementationVersionWithBuildDate().equals(twebpreferenciasTO.getVersaoAtual())) {
            mensagemLista.addMensagem("versaoAtualDoSistemaNaoConfereAplicacao", new String[]{twebpreferenciasTO.getVersaoAtual(), ManifestUtil.getImplementationVersionWithBuildDate()});
            throw new NegocioException(mensagemLista);
        }
        return twebpreferenciasTO;
    }

    @Override
    public HashMap<String, Object> validarDataHoraServidores(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        ObjectUtil.verificarCamposNulos(twebpreferenciasTO).orElseThrow(() -> new NegocioException("preferenciasSistemaNaoConfigurada"));
        LocalDateTime servidorAplicacao = LocalDateTime.now();
        LocalDateTime servidorBancoDeDados = consultarDataAtual();
        HashMap<String, Object> dataEHora = new HashMap();
        if (TwebpreferenciasAmbiente.HOMOLOGACAO.getAmbiente().equals(twebpreferenciasTO.getAmbiente())) {
            dataEHora.put("dataHoraServidorAplicacao", servidorAplicacao);
            dataEHora.put("dataHoraServidorBancoDeDados", servidorBancoDeDados);
            dataEHora.put("valida", true);
            return dataEHora;
        }

        int servidorAplicacaoDia = servidorAplicacao.getDayOfMonth();
        int servidorAplicacaoMes = servidorAplicacao.getMonthValue();
        int servidorAplicacaoAno = servidorAplicacao.getYear();
        int servidorAplicacaoHora = servidorAplicacao.getHour();
        int servidorAplicacaoMinuto = servidorAplicacao.getMinute();

        int servidorBancoDeDadosDia = servidorBancoDeDados.getDayOfMonth();
        int servidorBancoDeDadosMes = servidorBancoDeDados.getMonthValue();
        int servidorBancoDeDadosAno = servidorBancoDeDados.getYear();
        int servidorBancoDeDadosHora = servidorBancoDeDados.getHour();
        int servidorBancoDeDadosMinuto = servidorBancoDeDados.getMinute();

        int intervalo[] = verificaMargemDeErroAceita(servidorAplicacaoMinuto, servidorBancoDeDadosMinuto);

        dataEHora.put("dataHoraServidorAplicacao", servidorAplicacao);
        dataEHora.put("dataHoraServidorBancoDeDados", servidorBancoDeDados);
        dataEHora.put("valida", false);

        if (servidorAplicacaoDia == servidorBancoDeDadosDia
                && servidorAplicacaoMes == servidorBancoDeDadosMes
                && servidorAplicacaoAno == servidorBancoDeDadosAno
                && servidorAplicacaoHora == servidorBancoDeDadosHora
                && NumberUtil.between(servidorAplicacaoMinuto, intervalo[0], intervalo[1])
                && NumberUtil.between(servidorBancoDeDadosMinuto, intervalo[0], intervalo[1])) {
            dataEHora.put("valida", true);
        }
        return dataEHora;
    }

    private boolean validarLicenca(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        ObjectUtil.verificarCamposNulos(twebpreferenciasTO).orElseThrow(() -> new NegocioException("preferenciasSistemaNaoConfigurada"));
        ObjectUtil.verificarCamposNulos(twebpreferenciasTO.getLicencaHashCode()).orElseThrow(() -> new NegocioException("licencaNaoFoiInformada"));
        ObjectUtil.verificarCamposNulos(twebpreferenciasTO.getLicencaValidaAte()).orElseThrow(() -> new NegocioException("licencaNaoFoiInformada"));
        LocalDateTime horaInclusao = twebpreferenciasTO.getAudit().getIncluidoEm();
        LocalDateTime horaExpiracao = DateUtil.asLocalDateTime(twebpreferenciasTO.getLicencaValidaAte());
        Duration duration = DateUtil.getDiasDiferenca(horaInclusao, horaExpiracao);
        ObjectUtil.verificarCamposNulos(duration).orElseThrow(() -> new NegocioException("dataLicencaInvalida"));
        String value = duration.toString();
        if (EncrytedUtils.check(value, twebpreferenciasTO.getLicencaHashCode())) {
            LocalDateTime servidorBancoDeDados = consultarDataAtual();
            return servidorBancoDeDados.isBefore(horaExpiracao);
        }
        return false;
    }

    /**
     * Valida se os minutos estao com atraso/adiantado em ate 2 minutos
     *
     * @param minutoUm - Primeiro minuto no internvalo de 0-59 a ser valiado;
     * @param minutoDois - Segundo minuto no intervalo de 0-59 a ser validado;
     *
     * @return Array com o intervalo minimo/maximo em minutos permitido de
     * atraso/adiantado
     */
    private int[] verificaMargemDeErroAceita(int minutoUm, int minutoDois) {
        int minutoMaximoPermitido = 0;
        if (minutoUm > minutoDois) {
            minutoMaximoPermitido = minutoDois;
        } else {
            minutoMaximoPermitido = minutoUm;
        }
        int numeroMaximo = minutoMaximoPermitido + 2;
        int numeroMinimo = minutoMaximoPermitido - 2;
        if (numeroMinimo < 0) {
            numeroMinimo = 0;
        }
        int intervalo[] = {numeroMinimo, numeroMaximo};
        return intervalo;
    }

}
