/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Augusto-PC
 */
public interface AtividadeDAO{
    public boolean gravar(Atividade atividade);
    public ArrayList<Atividade> listar();
    public boolean excluir(Atividade atividade);
    public boolean alterar(Atividade atividade);
}