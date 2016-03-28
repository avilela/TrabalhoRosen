/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Augusto-PC
 */
public class Atividade {
    private int id;
    private int max_curso;
    private int max_participante;
    private String localizacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxCurso() {
        return max_curso;
    }

    public void setMaxCurso(int max_curso) {
        this.max_curso = max_curso;
    }

    public int getMaxParticipante() {
        return max_participante;
    }

    public void setMaxParticipante(int max_participante) {
        this.max_participante = max_participante;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
