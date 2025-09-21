package br.com.hera.model.dao;

import java.util.ArrayList;

public interface IDAO {
    public String inserir(Object object);
    public String alterar(Object object);
    public String excluir(Object object);
    public String listarUm(Object object);
    public ArrayList<Object> listarTodos();
}
