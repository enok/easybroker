package br.com.otavio.easybroker.to;
/**
 *
 * @author Octavio Braga
 */
public class UsuarioTO {

    private int codigo;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String sexo;
    private String admin;

    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }


    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    public String getAdmin(){
        return admin;
    }
    public void setAdmin(String admin){
        this.admin = admin;
    }

}
