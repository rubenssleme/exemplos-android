package br.gov.laramara.bean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.gov.laramara.dao.ColaboradorDao;
import br.gov.laramara.entidade.Colaborador;

import java.util.Locale;

@ManagedBean(name="colaboradorMB")
@ViewScoped
public class ColaboradorBean implements Serializable{
   	private static final long serialVersionUID = 9159105945035543620L;


	private List<Colaborador> colaborador;
   
         
    @ManagedProperty("#{colaboradorService}")
    private ColaboradorDao service;
    private List<Colaborador> filteredDepto;

    public ColaboradorBean() {
    }
     
    
    @PostConstruct
    public void init() {
        colaborador = service.createColaboradores();   
    }
 
     public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }
    
    
    public List<Colaborador> getColaboradores() {
        return colaborador;
    }
 
   
     
    public List<String> getNomes() {
        return service.getNomes();
    }
     
    public List<String> getEmpresas() {
        return service.getEmpresas();
    }
 
    public void setService(ColaboradorDao service) {
        this.service = service;
    }
     
    
    public List<Colaborador> getFilteredDeptos() {
        return filteredDepto;
    }
 
    public void setFilteredDeptos(List<Colaborador> filteredDeptos) {
        this.filteredDepto = filteredDeptos;
    }

    public void setFilteredEmpresas(List<Colaborador> filteredEmpresas) {
        this.colaborador = filteredEmpresas;
    }
    
    
 
}