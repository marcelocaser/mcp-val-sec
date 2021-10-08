package br.com.mcp.val.sec.entity.audit;

import br.com.core.util.LoggedUser;
import java.time.LocalDateTime;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 * <b>Classe:</b> AuditListener <br>
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
public class AuditListener {

    @PreRemove
    public void setRemoveOn(Auditable auditable) {
        /*Audit audit = auditable.getAudit();

        audit.setExcluidoEm(LocalDateTime.now());
        audit.setExcluidoPor(LoggedUser.get());*/
    }

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        if (audit == null) {
            audit = new Audit();
            auditable.setAudit(audit);
        }

        audit.setIncluidoEm(LocalDateTime.now());
        audit.setIncluidoPor(LoggedUser.get());
    }

    @PreUpdate
    public void setUpdatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        audit.setAlteradoEm(LocalDateTime.now());
        audit.setAlteradoPor(LoggedUser.get());
    }

}
