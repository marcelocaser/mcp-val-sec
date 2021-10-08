package br.com.mcp.val.sec.entity.audit;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <b>Classe:</b> Audit <br>
 * <b>Descrição:</b>     <br>
 *
 * <b>Projeto:</b> core <br>
 * <b>Pacote:</b> br.com.core.audit <br>
 * <b>Empresa:</b> Cifarma - Científica Farmacêutica LTDA. <br>
 *
 * Copyright (c) 2018 CIFARMA - Todos os direitos reservados.
 *
 * @author Caser
 * @version Revision: $$ Date: 28/09/2018
 */
@Embeddable
public class Audit implements Serializable {

    private static Audit instance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "INCLUIDO_POR", nullable = false, length = 60)
    private String incluidoPor;
    @Column(name = "INCLUIDO_EM")
    private LocalDateTime incluidoEm;
    @Size(max = 60)
    @Column(name = "ALTERADO_POR", length = 60)
    private String alteradoPor;
    @Column(name = "ALTERADO_EM")
    private LocalDateTime alteradoEm;
    @Size(max = 60)
    @Column(name = "EXCLUIDO_POR", length = 60)
    private String excluidoPor;
    @Column(name = "EXCLUIDO_EM")
    private LocalDateTime excluidoEm;

    public static Audit getInstance() {
        if (instance == null) {
            instance = new Audit();
        }
        return instance;
    }

    public String getIncluidoPor() {
        return incluidoPor;
    }

    public void setIncluidoPor(String incluidoPor) {
        this.incluidoPor = incluidoPor;
    }

    public LocalDateTime getIncluidoEm() {
        return incluidoEm;
    }

    public void setIncluidoEm(LocalDateTime incluidoEm) {
        this.incluidoEm = incluidoEm;
    }

    public String getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(String alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public LocalDateTime getAlteradoEm() {
        return alteradoEm;
    }

    public void setAlteradoEm(LocalDateTime alteradoEm) {
        this.alteradoEm = alteradoEm;
    }

    public String getExcluidoPor() {
        return excluidoPor;
    }

    public void setExcluidoPor(String excluidoPor) {
        this.excluidoPor = excluidoPor;
    }

    public LocalDateTime getExcluidoEm() {
        return excluidoEm;
    }

    public void setExcluidoEm(LocalDateTime excluidoEm) {
        this.excluidoEm = excluidoEm;
    }

}
