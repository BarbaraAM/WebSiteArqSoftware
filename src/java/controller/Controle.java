/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Acesso;
import model.Departamento;
import model.EmpresaDAO;

@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
public class Controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
        //programação arquivo 
        //flag é como um ponteiro,(ação do formulario)Controller(MVC)
        String flag, msg = "";
        flag = request.getParameter("flag");

        //recebendo o que o usuario vai digitar
        if (flag.equals("login")) {
            String user, password;
 

            user = request.getParameter("usuario");
            password = request.getParameter("senha");
            EmpresaDAO dao = new EmpresaDAO();
            Acesso acesso = dao.validarLogin(user, password);
            if (acesso == null) {
                 RequestDispatcher disp = request.getRequestDispatcher("Erro.jsp");
                   disp.forward(request, response);
            } else {
                String cargo, nome, mensagem;
               cargo =  acesso.getFuncionario().getCargoFuncionario();
               nome =  acesso.getFuncionario().getNomeFuncionario();
               out.print("Bem vindo "+ nome + "  <br> Cargo: " + cargo);
               mensagem = "Bem vindo, " + nome;
               
               //equalsIgnoreCase eh pra ignorar se for letra maiuscula ou nao
               if (cargo.equalsIgnoreCase("dev")) {
                   RequestDispatcher disp = request.getRequestDispatcher("AcessoGerente.jsp");
                   disp.forward(request, response);
               } else if(cargo.equalsIgnoreCase("Vendedor")) {
                   RequestDispatcher disp = request.getRequestDispatcher("AcessoVendedor.jps");
                   disp.forward(request, response);
               } else {
                   RequestDispatcher disp = request.getRequestDispatcher("AcessoOutro.jps");
                   disp.forward(request, response);

               }
            }
            
            //tem q ser igual como esta escrito no cadastrodep.html

      
        } else if (flag.equalsIgnoreCase("CadastroDepartamento")) {
            Departamento dep;
            dep = new Departamento();
            dep.setIdDepartamento(request.getParameter("idDepartamento"));
            dep.setNomeDepartamento(request.getParameter("nomeDepartamento"));
            dep.setFoneDepartamento(request.getParameter("telefoneDepartamento"));
            
            EmpresaDAO dao = new EmpresaDAO();
            int retorno = dao.salvarDepartamento(dep);
            switch (retorno) {
                case 1:
                    msg = "Departamento salvo com sucesso.";
                    break;
                case 2:
                    msg = "Departamento já cadastrado.";
                    break;
                case 3:
                    msg = "Erro: Entre em contato com o adminstrador.";
                    break;
                default:
                    break;
            }
            request.setAttribute("m", msg);
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            disp.forward(request, response);
        }    
    }

    @Override
    //formulario gtml get
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    //formulario html post 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}