package br.com.mcp.val.sec.entity.audit;

/**
 * <b>Classe:</b> Auditable <br>
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
public interface Auditable {

    Audit getAudit();

    void setAudit(Audit audit);

}
