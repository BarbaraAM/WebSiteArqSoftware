/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//criar metodos para conexão

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class EmpresaDAO {
    
    private EntityManagerFactory conn;
    private EntityManager manager;
    
     //conecta banco
    //void pq n retorna nd 
    public void conectar() {
        conn = Persistence.createEntityManagerFactory("WebSiteArqSoftwarePU");
        manager = conn.createEntityManager();
    }
    //validar login
    public Acesso validarLogin(String u, String s){
        conectar();
        try {
        //traz um OBJETO do tipo Acesso
        TypedQuery<Acesso> query = manager.createNamedQuery("Acesso.findByEmailSenhaFuncionario", Acesso.class);
        query.setParameter("senhaFuncionario", s);
        query.setParameter("emailFuncionario", u);
        Acesso acesso = query.getSingleResult();
        
        return acesso; 
        } catch(NoResultException ex) {
            return null;
        }
    }
    
    //dados que passou do dep vai salvar aqui, 
    public int salvarDepartamento(Departamento dep) {
        try {
        conectar();
        manager.getTransaction().begin();
        //comando insert no bd
        manager.persist(dep);
        //commit nao da pra reverter, para ter ctz q os dados serão salvar
        manager.getTransaction().commit(); 
        return 1; // deu certo
    } catch(EntityExistsException ex) {
        return 2; //já cadastrado
    } catch(Exception ex) {
        return 3; //Deu qualquer outro erro
    }
  }
}
