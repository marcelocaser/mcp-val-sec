package br.com.mcp.val.sec.entity.persistence;

import br.com.core.exception.NegocioException;
import br.com.mcp.val.sec.entity.TwebpreferenciasTO;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>Classe:</b> TwebpreferenciasPO <br>
 * <b>Descrição:</b>     <br>
 *
 * <b>Projeto:</b> mcp-val-sec <br>
 * <b>Pacote:</b> mcp.val.sec.persistence.persistence <br>
 * <b>Empresa:</b> Caser&Buys Consultoria. <br>
 *
 * Copyright (c) 2021 CASER&BUYS - Todos os direitos reservados.
 *
 * @author marcelocaser
 * @version Revision: $$ Date: 24/09/2021
 */
@Repository
public class TwebpreferenciasPO extends AbstractMvsPersistence<TwebpreferenciasTO, Object> {

    public TwebpreferenciasPO() {
        setClazz(TwebpreferenciasTO.class);
    }

    @Transactional(transactionManager = "transactionManager")
    public TwebpreferenciasTO alterar(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        return update(twebpreferenciasTO);
    }

    public TwebpreferenciasTO consultar(TwebpreferenciasTO twebpreferenciasTO) {
        return find(twebpreferenciasTO);
    }

    @Transactional(transactionManager = "transactionManager")
    public void excluir(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        delete(twebpreferenciasTO);
    }

    @Transactional(transactionManager = "transactionManager")
    public void incluir(TwebpreferenciasTO twebpreferenciasTO) throws NegocioException {
        create(twebpreferenciasTO);
    }

    public List<TwebpreferenciasTO> listar(TwebpreferenciasTO twebpreferenciasTO) {
        return list(twebpreferenciasTO);
    }

}
