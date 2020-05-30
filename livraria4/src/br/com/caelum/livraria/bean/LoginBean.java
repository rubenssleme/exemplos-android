package br.com.caelum.livraria.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{


	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public String efetuarLogin() {
		System.out.println("Fazendo login do usuario: " + this.usuario.getEmail());
		boolean existe  = new UsuarioDao().existe(this.usuario);
		if(existe) {
			return "livro?faces-redirect-true";
		}
		return null;
	}

	
	
	
//	
//
//	public List<Autor> getAutores() {
//		return new DAO<Autor>(Autor.class).listaTodos();
//	}
//
//	public List<Autor> getAutoresDoLivro() {
//		return this.livro.getAutores();
//	}
//
//	public void adicionarAutor() {
//
//		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
//		this.livro.adicionaAutor(autor);
//		System.out.println("Usando autor " + autor.getNome());
//	}
//
//	public void gravar() {
//		System.out.println("Gravando livro " + this.livro.getTitulo());
//
//		if (livro.getAutores().isEmpty()) {
//			//throw new RuntimeException("Livro deve ter pelo menos um Autor.");
//			 FacesContext.getCurrentInstance().addMessage("autor",  new FacesMessage("Livro deve ter pelo menos um Autor"));
//	            return;
//		}else {
//			new DAO<Livro>(Livro.class).adiciona(this.livro);
//            this.livro = new Livro();
//		}
//
//		
//	}
//	
//	//Criando validadores personalizados
//	public void comecaComDigitoUm(FacesContext fc,UIComponent component,Object value) throws ValidationException{
//		String valor = value.toString();
//		if(!valor.startsWith("1")) {
//			throw new ValidatorException(new FacesMessage("O ISBN deve começar com digito - 1"));
//		}
//		
//	}


}
