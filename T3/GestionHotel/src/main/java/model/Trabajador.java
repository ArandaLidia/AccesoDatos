package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
//Serializable hacer el objeto en trozo mas pequeños para llevar a base de datos y luego poder volver a construir -> Serializacion
//private static long serialVersionUID = 1L -> para ficheros -> flujo de datos.

/* 1ºImplementar serializable
* 2º Contructor vacío y con todo
* 3º Configurar como se va a conectar hibernate con la BBDD (indirectamente)
*               -En resources crear fichero de configuración:
*                  -En trabajador @Entity(name="Trabajadores")
*                   - Inserta en tabla trabajadores
*               -Poner @Id
*                       @GenerateValue(strategy = GenerationType.IDENTITY)
*                       @Column en cada atributo
*                       @Column(name="name") -> Si el nombre de la bbdd no es el mismo al de la variable
* */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="trabajadores")
public class Trabajador implements Serializable {

    //Datos que vamos a querer guardar en BBDD, todas las variables privadas.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //pk en bbdd
    @Column (name ="name")
    private String nombre;
    @Column(name = "surename")
    private String apellido;
    @Column
    private String correo;
    @Column(name="phone")
    private int telefono;

    //Constructor sin id ya que es autoincremental y no hay que intruducirlo manualmente
    public Trabajador(String nombre, String apellido, String correo, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
}
