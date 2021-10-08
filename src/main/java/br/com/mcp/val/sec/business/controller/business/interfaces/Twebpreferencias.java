package br.com.mcp.val.sec.business.controller.business.interfaces;

import br.com.core.exception.NegocioException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import br.com.mcp.val.sec.entity.TwebpreferenciasTO;

/**
 * <b>Classe:</b> Twebpreferencias <br>
 * <b>Descrição:</b>     <br>
 *
 * <b>Projeto:</b> cifarma-entity <br>
 * <b>Pacote:</b> br.com.cifarma.entity.business.controller.business.interfaces
 * <br>
 * <b>Empresa:</b> Cifarma - Científica Farmacêutica LTDA. <br>
 *
 * Copyright (c) 2017 CIFARMA - Todos os direitos reservados.
 *
 * @author marce
 * @version Revision: $$ Date: 05/06/2017
 */
public interface Twebpreferencias {

    enum TwebpreferenciasStatus {
        SIM("SIM", "", 'S'),
        NAO("NAO", "", 'N');

        private final String status;
        private final String codigo;
        private final Character statusToChar;

        private TwebpreferenciasStatus(String status, String codigo, Character statusToChar) {
            this.status = status;
            this.codigo = codigo;
            this.statusToChar = statusToChar;
        }

        public String getStatus() {
            return status;
        }

        public String getCodigo() {
            return codigo;
        }

        public Character getStatusToChar() {
            return statusToChar;
        }

        public static TwebpreferenciasStatus getByCodido(Integer codigo) {
            for (TwebpreferenciasStatus e : values()) {
                if (e.codigo.equals(String.valueOf(codigo))) {
                    return e;
                }
            }
            throw new IllegalArgumentException();
        }

        public static TwebpreferenciasStatus getByStatus(String status) {
            for (TwebpreferenciasStatus e : values()) {
                if (e.status.equals(status)) {
                    return e;
                }
            }
            throw new IllegalArgumentException();
        }

        public static TwebpreferenciasStatus getByStatus(Character statusToChar) {
            for (TwebpreferenciasStatus e : values()) {
                if (e.statusToChar.equals(statusToChar)) {
                    return e;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    enum TwebpreferenciasAmbiente {
        HOMOLOGACAO("HOMOLOGAÇÃO", "", 'H'),
        PRODUCAO("PRODUÇÃO", "", 'P');

        private final String ambiente;
        private final String codigo;
        private final Character ambienteToChar;

        private TwebpreferenciasAmbiente(String ambiente, String codigo, Character ambienteToChar) {
            this.ambiente = ambiente;
            this.codigo = codigo;
            this.ambienteToChar = ambienteToChar;
        }

        public String getAmbiente() {
            return ambiente;
        }

        public String getCodigo() {
            return codigo;
        }

        public Character getAmbienteToChar() {
            return ambienteToChar;
        }

        public static TwebpreferenciasAmbiente getByCodigo(Integer codigo) {
            for (TwebpreferenciasAmbiente e : values()) {
                if (e.codigo.equals(String.valueOf(codigo))) {
                    return e;
                }
            }
            throw new IllegalArgumentException();
        }

        public static TwebpreferenciasAmbiente getByAmbiente(String ambiente) {
            for (TwebpreferenciasAmbiente e : values()) {
                if (e.ambiente.equals(ambiente)) {
                    return e;
                }
            }
            throw new IllegalArgumentException();
        }

        public static TwebpreferenciasAmbiente getByAmbiente(Character ambienteToChar) {
            for (TwebpreferenciasAmbiente e : values()) {
                if (e.ambienteToChar.equals(ambienteToChar)) {
                    return e;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    enum TwebpreferenciasScheduler {
        CORREIOS("CORREIOS", "", 'C'),
        E_MAIL("E-MAIL", "", 'E');

        private final String scheduler;
        private final String codigo;
        private final Character schedulerToChar;

        private TwebpreferenciasScheduler(String scheduler, String codigo, Character schedulerToChar) {
            this.scheduler = scheduler;
            this.codigo = codigo;
            this.schedulerToChar = schedulerToChar;
        }

        public String getScheduler() {
            return scheduler;
        }

        public String getCodigo() {
            return codigo;
        }

        public Character getSchedulerToChar() {
            return schedulerToChar;
        }

        public static TwebpreferenciasScheduler getByCodido(Integer codigo) {
            for (TwebpreferenciasScheduler e : values()) {
                if (e.codigo.equals(String.valueOf(codigo))) {
                    return e;
                }
            }
            throw new IllegalArgumentException();
        }

        public static TwebpreferenciasScheduler getByStatus(String scheduler) {
            for (TwebpreferenciasScheduler e : values()) {
                if (e.scheduler.equals(scheduler)) {
                    return e;
                }
            }
            throw new IllegalArgumentException();
        }

        public static TwebpreferenciasScheduler getByStatus(Character schedulerToChar) {
            for (TwebpreferenciasScheduler e : values()) {
                if (e.schedulerToChar.equals(schedulerToChar)) {
                    return e;
                }
            }
            throw new IllegalArgumentException();
        }

    }

    enum TwebpreferenciasPattern {
        // padrao aceito: [nome_serviço]@[host_ip]:[porta]/[contexto_aplicacao]
        URI_MICRO_SERVICOS("^[a-zA-Z0-9]+(-?)+[a-zA-Z0-9]+@[a-zA-Z0-9.]+\\:?(\\d{2}|\\d{4})\\/?([a-zA-Z]?)+$");

        private final String pattern;

        private TwebpreferenciasPattern(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }

    }

    public TwebpreferenciasTO alterar(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException;

    public TwebpreferenciasTO consultar(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException;

    public LocalDateTime consultarDataAtual() throws NegocioException;

    public void excluir(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException;

    public void incluir(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException;

    public List<TwebpreferenciasTO> listar(TwebpreferenciasTO twebpreferenciasTO);

    public String[] retornaTempoExecucaoScheduler(TwebpreferenciasTO twebpreferenciasTO, TwebpreferenciasScheduler scheduler, long tempoDeInatividade) throws NegocioException;

    public TwebpreferenciasTO validarAcesso(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException;

    public HashMap<String, Object> validarDataHoraServidores(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException;
}
