/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Produto;
import repositorio.RepositorioProdutos;

/**
 * REST Web Service
 *
 * @author tcv
 */
@Path("produtos")
public class ProdutoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutoWS
     */
    public ProdutoWS() {
        
    }

    /**
     * Retrieves representation of an instance of ws.ProdutoWS
     * @return an instance of model.Produto
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public List<Produto> getProdutos(){
            return RepositorioProdutos.getInstance().listar();
    }

    /**
     * PUT method for updating or creating an instance of ProdutoWS
     * @param content representation for the resource
     */
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Produto getProduto(@PathParam("codigo") int cod){
        return RepositorioProdutos.getInstance().buscarPorCodigo(cod);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void adicionarProduto(Produto p, @Context final HttpServletResponse response){
        
        RepositorioProdutos.getInstance().inserir(p);
        //Alterar o código para 201 (Created)
        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();            
        } catch (IOException e){
            //ERRO 500
            throw new InternalServerErrorException();
        }
    }
    
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarProduto(@PathParam("codigo") int cod, Produto produto){
        
        Produto p = RepositorioProdutos.getInstance().buscarPorCodigo(cod);
        p.setNome(produto.getNome());
        p.setPreco(produto.getPreco());
        RepositorioProdutos.getInstance().atualizar(p);
    }
    
    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Produto removerProduto(@PathParam("codigo") int cod){
        Produto p = RepositorioProdutos.getInstance().buscarPorCodigo(cod);
        RepositorioProdutos.getInstance().excluir(p);
        return p;
    }
}
