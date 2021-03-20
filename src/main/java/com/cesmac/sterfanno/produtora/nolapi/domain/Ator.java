package com.cesmac.sterfanno.produtora.nolapi.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtor;

    @Column(length = 150)
    private String nome;

    @Temporal(value= TemporalType.DATE)
    private Date dataNascimento;

    @Column(length = 1)
    private String sexo;
    private String biografia;

    public Ator() {
    }


    public Long getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Long idAtor) {
        this.idAtor = idAtor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
