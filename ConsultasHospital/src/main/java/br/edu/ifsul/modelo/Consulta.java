package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar data;
    
    @Column(nullable = false, columnDefinition = "time")
    private Calendar hora;
    
    @NotBlank(message = "A pre consulta não pode ser em branco")
    @Length(max = 50, message = "A pre consulta não pode ter mais que {max} caracteres")
    @Column(name = "preconsulta", nullable = false, length = 50)
    private String preConsulta;
    
    @NotBlank(message = "A pos consulta não pode ser em branco")
    @Length(max = 50, message = "A pos consulta não pode ter mais que {max} caracteres")
    @Column(name = "posconsulta", nullable = false, length = 50)
    private String posConsulta;
    
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false)
    private Medico medico;
    
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
    

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Exame> exames = new ArrayList<>();
    

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Receituario> receituarios = new ArrayList<>();


    public Consulta() {
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPreConsulta() {
        return preConsulta;
    }

    public void setPreConsulta(String preConsulta) {
        this.preConsulta = preConsulta;
    }

    public String getPosConsulta() {
        return posConsulta;
    }

    public void setPosConsulta(String posConsulta) {
        this.posConsulta = posConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(Exame exames) {
        this.exames.add(exames);
    }

    public List<Receituario> getReceituarios() {
        return receituarios;
    }

    public void setReceituarios(Receituario receituarios) {
        this.receituarios.add(receituarios);
    }

    
    
    
}
