package app.beans.implementations;

import app.beans.interfaces.Comentario;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comentarios")
public class ComentarioBean implements Comentario{



}
