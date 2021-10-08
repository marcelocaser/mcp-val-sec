package br.com.mcp.val.sec.entity;

import br.com.mcp.val.sec.entity.audit.Audit;
import br.com.mcp.val.sec.entity.audit.AuditListener;
import br.com.mcp.val.sec.entity.audit.Auditable;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;

/**
 * <b>Classe:</b> TwebpreferenciasTO <br>
 * <b>Descrição:</b>     <br>
 *
 * <b>Projeto:</b> mcp-val-sec <br>
 * <b>Pacote:</b> mcp.val.sec.entity <br>
 * <b>Empresa:</b> Cifarma - Científica Farmacêutica LTDA. <br>
 *
 * Copyright (c) 2021 CIFARMA - Todos os direitos reservados.
 *
 * @author marcelocaser
 * @version Revision: $$ Date: 08/10/2021
 */
@Entity
@EntityListeners(AuditListener.class)
@Table(name = "TWEBPREFERENCIAS", catalog = "", schema = "INTRANET")
@OptimisticLocking(type = OptimisticLockingType.VERSION_COLUMN, cascade = true)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwebpreferenciasTO.findAll", query = "SELECT t FROM TwebpreferenciasTO t")})
public class TwebpreferenciasTO implements Serializable, Auditable {

    private static final long serialVersionUID = 1L;
    @Embedded
    private Audit audit;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Size(max = 15)
    @Column(length = 15)
    private String tema;
    @Size(max = 15)
    @Column(length = 15)
    private String layout;
    @Size(max = 20)
    @Column(name = "MENU_CLASS", length = 20)
    private String menuClass;
    @Size(max = 50)
    @Column(name = "MENU_LAYOUT", length = 50)
    private String menuLayout;
    @Size(max = 15)
    @Column(name = "PROFILE_MODE", length = 15)
    private String profileMode;
    @Column(name = "ACTIVE_DIRECTORY")
    private Character activeDirectory;
    @Size(max = 20)
    @Column(name = "IP_SERVIDOR_ACTIVE_DIRECTORY", length = 20)
    private String ipServidorActiveDirectory;
    @Size(max = 30)
    @Column(name = "DOMINIO_ACTIVE_DIRECTORY", length = 30)
    private String dominioActiveDirectory;
    @Size(max = 15)
    @Column(name = "SIGLA_EMPRESA_PADRAO", length = 15)
    private String siglaEmpresaPadrao;
    @Column(name = "SISTEMA_HABILITADO")
    private Character sistemaHabilitado;
    @Column(name = "SISTEMA_VALIDADO")
    private Character sistemaValidado;
    @Size(max = 15)
    @Column(name = "CORREIOS_CODIGO_ADMINISTRATIVO", length = 15)
    private String correiosCodigoAdministrativo;
    @Size(max = 15)
    @Column(name = "CORREIOS_CONTRATO", length = 15)
    private String correiosContrato;
    @Size(max = 15)
    @Column(name = "CORREIOS_ID_LR", length = 15)
    private String correiosIdLr;
    @Size(max = 15)
    @Column(name = "CORREIOS_SENHA_LR", length = 15)
    private String correiosSenhaLr;
    @Size(max = 100)
    @Column(name = "CORREIOS_URL_LR", length = 100)
    private String correiosUrlLr;
    @Size(max = 60)
    @Column(name = "CORREIOS_USUARIO_WS", length = 60)
    private String correiosUsuarioWs;
    @Size(max = 15)
    @Column(name = "CORREIOS_SENHA_WS", length = 15)
    private String correiosSenhaWs;
    @Size(max = 100)
    @Column(name = "CORREIOS_URL_WS", length = 100)
    private String correiosUrlWs;
    @Column(name = "ULTIMO_EMAIL_SITE_CIFARMA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoEmailSiteCifarma;
    @Column(name = "ULTIMO_RETORNO_CORREIOS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoRetornoCorreios;
    @Size(max = 15)
    @Column(length = 15)
    private String ambiente;
    @Column(name = "ULTIMAS_SENHAS")
    private Short ultimasSenhas;
    @Size(max = 60)
    @Column(name = "VERSAO_ATUAL", length = 60)
    private String versaoAtual;
    @Size(max = 3)
    @Column(name = "VERSAO_BOOTSTRAP", length = 3)
    private String versaoBootstrap;
    @Size(max = 100)
    @Column(name = "REINF_URL_SERVICO", length = 100)
    private String reinfUrlServico;
    @Size(max = 100)
    @Column(name = "REINF_URL_CONSULTA", length = 100)
    private String reinfUrlConsulta;
    @Size(max = 60)
    @Column(name = "REINF_PASTA_COMPARTILHADA", length = 60)
    private String reinfPastaCompartilhada;
    @Size(max = 120)
    @Column(name = "NFE_URL_CONSULTA", length = 120)
    private String nfeUrlConsulta;
    @Size(max = 15)
    @Column(name = "USUARIO_ACESSO_COMPARTILHADO", length = 15)
    private String usuarioAcessoCompartilhado;
    @Size(max = 50)
    @Column(name = "SENHA_ACESSO_COMPARTILHADO", length = 50)
    private String senhaAcessoCompartilhado;
    @Lob
    @Column(name = "GMAIL_CREDENTIALS")
    private byte[] gmailCredentials;
    @Size(max = 60)
    @Column(name = "TOKEN_API_CALENDARIO", length = 60)
    private String tokenApiCalendario;
    @Size(max = 40)
    @Column(name = "RESPONSAVEL_CAC", length = 40)
    private String responsavelCac;
    @Column(name = "QUANTIDADE_PRODUTO_COLABORADOR")
    private Short quantidadeProdutoColaborador;
    @Column(name = "MEDDRA_A_PARTIR_DE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date meddraAPartirDe;
    @Column(name = "UTILIZA_PROXY")
    private Character utilizaProxy;
    @Size(max = 20)
    @Column(name = "SERVIDOR_PROXY", length = 20)
    private String servidorProxy;
    @Size(max = 4)
    @Column(name = "PORTA_PROXY", length = 4)
    private String portaProxy;
    @Lob
    @Column(name = "NAO_USAR_SERVIDOR_PROXY")
    private String naoUsarServidorProxy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LICENCA_VALIDA_ATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date licencaValidaAte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "LICENCA_HASH_CODE", nullable = false, length = 70)
    private String licencaHashCode;
    @Lob
    @Column(name = "MICRO_SERVICOS")
    private String microServicos;
    @Version
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long version;

    public TwebpreferenciasTO() {
    }

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public TwebpreferenciasTO(Integer id) {
        this.id = id;
    }

    public TwebpreferenciasTO(Integer id, Date licencaValidaAte, String licencaHashCode, Long version) {
        this.id = id;
        this.licencaValidaAte = licencaValidaAte;
        this.licencaHashCode = licencaHashCode;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }

    public String getMenuLayout() {
        return menuLayout;
    }

    public void setMenuLayout(String menuLayout) {
        this.menuLayout = menuLayout;
    }

    public String getProfileMode() {
        return profileMode;
    }

    public void setProfileMode(String profileMode) {
        this.profileMode = profileMode;
    }

    public Character getActiveDirectory() {
        return activeDirectory;
    }

    public void setActiveDirectory(Character activeDirectory) {
        this.activeDirectory = activeDirectory;
    }

    public String getIpServidorActiveDirectory() {
        return ipServidorActiveDirectory;
    }

    public void setIpServidorActiveDirectory(String ipServidorActiveDirectory) {
        this.ipServidorActiveDirectory = ipServidorActiveDirectory;
    }

    public String getDominioActiveDirectory() {
        return dominioActiveDirectory;
    }

    public void setDominioActiveDirectory(String dominioActiveDirectory) {
        this.dominioActiveDirectory = dominioActiveDirectory;
    }

    public String getSiglaEmpresaPadrao() {
        return siglaEmpresaPadrao;
    }

    public void setSiglaEmpresaPadrao(String siglaEmpresaPadrao) {
        this.siglaEmpresaPadrao = siglaEmpresaPadrao;
    }

    public Character getSistemaHabilitado() {
        return sistemaHabilitado;
    }

    public void setSistemaHabilitado(Character sistemaHabilitado) {
        this.sistemaHabilitado = sistemaHabilitado;
    }

    public Character getSistemaValidado() {
        return sistemaValidado;
    }

    public void setSistemaValidado(Character sistemaValidado) {
        this.sistemaValidado = sistemaValidado;
    }

    public String getCorreiosCodigoAdministrativo() {
        return correiosCodigoAdministrativo;
    }

    public void setCorreiosCodigoAdministrativo(String correiosCodigoAdministrativo) {
        this.correiosCodigoAdministrativo = correiosCodigoAdministrativo;
    }

    public String getCorreiosContrato() {
        return correiosContrato;
    }

    public void setCorreiosContrato(String correiosContrato) {
        this.correiosContrato = correiosContrato;
    }

    public String getCorreiosIdLr() {
        return correiosIdLr;
    }

    public void setCorreiosIdLr(String correiosIdLr) {
        this.correiosIdLr = correiosIdLr;
    }

    public String getCorreiosSenhaLr() {
        return correiosSenhaLr;
    }

    public void setCorreiosSenhaLr(String correiosSenhaLr) {
        this.correiosSenhaLr = correiosSenhaLr;
    }

    public String getCorreiosUrlLr() {
        return correiosUrlLr;
    }

    public void setCorreiosUrlLr(String correiosUrlLr) {
        this.correiosUrlLr = correiosUrlLr;
    }

    public String getCorreiosUsuarioWs() {
        return correiosUsuarioWs;
    }

    public void setCorreiosUsuarioWs(String correiosUsuarioWs) {
        this.correiosUsuarioWs = correiosUsuarioWs;
    }

    public String getCorreiosSenhaWs() {
        return correiosSenhaWs;
    }

    public void setCorreiosSenhaWs(String correiosSenhaWs) {
        this.correiosSenhaWs = correiosSenhaWs;
    }

    public String getCorreiosUrlWs() {
        return correiosUrlWs;
    }

    public void setCorreiosUrlWs(String correiosUrlWs) {
        this.correiosUrlWs = correiosUrlWs;
    }

    public Date getUltimoEmailSiteCifarma() {
        return ultimoEmailSiteCifarma;
    }

    public void setUltimoEmailSiteCifarma(Date ultimoEmailSiteCifarma) {
        this.ultimoEmailSiteCifarma = ultimoEmailSiteCifarma;
    }

    public Date getUltimoRetornoCorreios() {
        return ultimoRetornoCorreios;
    }

    public void setUltimoRetornoCorreios(Date ultimoRetornoCorreios) {
        this.ultimoRetornoCorreios = ultimoRetornoCorreios;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public Short getUltimasSenhas() {
        return ultimasSenhas;
    }

    public void setUltimasSenhas(Short ultimasSenhas) {
        this.ultimasSenhas = ultimasSenhas;
    }

    public String getVersaoAtual() {
        return versaoAtual;
    }

    public void setVersaoAtual(String versaoAtual) {
        this.versaoAtual = versaoAtual;
    }

    public String getVersaoBootstrap() {
        return versaoBootstrap;
    }

    public void setVersaoBootstrap(String versaoBootstrap) {
        this.versaoBootstrap = versaoBootstrap;
    }

    public String getReinfUrlServico() {
        return reinfUrlServico;
    }

    public void setReinfUrlServico(String reinfUrlServico) {
        this.reinfUrlServico = reinfUrlServico;
    }

    public String getReinfUrlConsulta() {
        return reinfUrlConsulta;
    }

    public void setReinfUrlConsulta(String reinfUrlConsulta) {
        this.reinfUrlConsulta = reinfUrlConsulta;
    }

    public String getReinfPastaCompartilhada() {
        return reinfPastaCompartilhada;
    }

    public void setReinfPastaCompartilhada(String reinfPastaCompartilhada) {
        this.reinfPastaCompartilhada = reinfPastaCompartilhada;
    }

    public String getNfeUrlConsulta() {
        return nfeUrlConsulta;
    }

    public void setNfeUrlConsulta(String nfeUrlConsulta) {
        this.nfeUrlConsulta = nfeUrlConsulta;
    }

    public String getUsuarioAcessoCompartilhado() {
        return usuarioAcessoCompartilhado;
    }

    public void setUsuarioAcessoCompartilhado(String usuarioAcessoCompartilhado) {
        this.usuarioAcessoCompartilhado = usuarioAcessoCompartilhado;
    }

    public String getSenhaAcessoCompartilhado() {
        return senhaAcessoCompartilhado;
    }

    public void setSenhaAcessoCompartilhado(String senhaAcessoCompartilhado) {
        this.senhaAcessoCompartilhado = senhaAcessoCompartilhado;
    }

    public byte[] getGmailCredentials() {
        return gmailCredentials;
    }

    public void setGmailCredentials(byte[] gmailCredentials) {
        this.gmailCredentials = gmailCredentials;
    }

    public String getTokenApiCalendario() {
        return tokenApiCalendario;
    }

    public void setTokenApiCalendario(String tokenApiCalendario) {
        this.tokenApiCalendario = tokenApiCalendario;
    }

    public String getResponsavelCac() {
        return responsavelCac;
    }

    public void setResponsavelCac(String responsavelCac) {
        this.responsavelCac = responsavelCac;
    }

    public Short getQuantidadeProdutoColaborador() {
        return quantidadeProdutoColaborador;
    }

    public void setQuantidadeProdutoColaborador(Short quantidadeProdutoColaborador) {
        this.quantidadeProdutoColaborador = quantidadeProdutoColaborador;
    }

    public Date getMeddraAPartirDe() {
        return meddraAPartirDe;
    }

    public void setMeddraAPartirDe(Date meddraAPartirDe) {
        this.meddraAPartirDe = meddraAPartirDe;
    }

    public Character getUtilizaProxy() {
        return utilizaProxy;
    }

    public void setUtilizaProxy(Character utilizaProxy) {
        this.utilizaProxy = utilizaProxy;
    }

    public String getServidorProxy() {
        return servidorProxy;
    }

    public void setServidorProxy(String servidorProxy) {
        this.servidorProxy = servidorProxy;
    }

    public String getPortaProxy() {
        return portaProxy;
    }

    public void setPortaProxy(String portaProxy) {
        this.portaProxy = portaProxy;
    }

    public String getNaoUsarServidorProxy() {
        return naoUsarServidorProxy;
    }

    public void setNaoUsarServidorProxy(String naoUsarServidorProxy) {
        this.naoUsarServidorProxy = naoUsarServidorProxy;
    }

    public Date getLicencaValidaAte() {
        return licencaValidaAte;
    }

    public void setLicencaValidaAte(Date licencaValidaAte) {
        this.licencaValidaAte = licencaValidaAte;
    }

    public String getLicencaHashCode() {
        return licencaHashCode;
    }

    public void setLicencaHashCode(String licencaHashCode) {
        this.licencaHashCode = licencaHashCode;
    }

    public String getMicroServicos() {
        return microServicos;
    }

    public void setMicroServicos(String microServicos) {
        this.microServicos = microServicos;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwebpreferenciasTO)) {
            return false;
        }
        TwebpreferenciasTO other = (TwebpreferenciasTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.mcp.val.sec.entity.TwebpreferenciasTO_1[ id=" + id + " ]";
    }

}
