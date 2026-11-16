import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//---------------------------------------------------------
// Herencia: Persona (abstracta) <- Estudiante, Docente
//---------------------------------------------------------
abstract class Persona {
  private final String nombre;
  private final String ci;

  protected Persona(String nombre, String ci) {
    this.nombre = nombre;
    this.ci = ci;
  }

  public String getNombre() {
    return nombre;
  }

  public String getCi() {
    return ci;
  }

  public abstract String toString();
}

// Enunciado 3
class Estudiante extends Persona {
  private final String codigo;
  // Asociación: el estudiante conoce sus inscripciones
  private final List<Inscripcion> inscripciones = new ArrayList<>();

  public Estudiante(String nombre, String ci, String codigo) {
    super(nombre, ci);
    this.codigo = codigo;
  }

  public String getCodigo() {
    return codigo;
  }

  public Inscripcion inscribirse(Materia materia) {
    // Enunciado 6 inciso 1
    for (Inscripcion i : inscripciones) {
      if (i.getMateria() == materia) {
        throw new IllegalStateException("El estudiante ya está inscrito en la materia");
      }
    }
    Inscripcion inscripcion = new Inscripcion(this, materia, LocalDate.now());
    inscripciones.add(inscripcion);
    materia.registrarInscripcion(inscripcion);
    return inscripcion;
  }

  public List<Inscripcion> getInscripciones() {
    return Collections.unmodifiableList(inscripciones);
  }

  @Override
  public String toString() {
    return "Estudiante " + getNombre() + " (código " + codigo + ")";
  }
}

// Enunciado 7
class Ayudante extends Estudiante {
  private int cargaHoraria;
  private Materia materia;

  public Ayudante(String nombre, String ci, String codigo, int cargaHoraria) {
    super(nombre, ci, codigo);
    this.cargaHoraria = cargaHoraria;
  }

  public void asignarMateria(Materia materia) {
    this.materia = materia;
  }

  public Materia getMateria() {
    return materia;
  }

  public Docente getDocente() {
    return materia.getDocente();
  }
}

class Docente extends Persona {
  private final String especialidad;
  // Asociación: el docente conoce las materias que dicta
  private final List<Materia> materias = new ArrayList<>();
  private Carrera carrera;

  public Docente(String nombre, String ci, String especialidad) {
    super(nombre, ci);
    this.especialidad = especialidad;
  }

  public void dictar(Materia materia) {
    // Enunciado 6 inciso 2
    if (materia.getDocente() != null) {
      throw new IllegalStateException("La materia ya tiene docente");
    }
    materias.add(materia);
    // Enunciado 3
    materia.setDocente(this);
  }

  // Enunciado 4
  // Dependencia: Acta se crea y se devuelve, pero NO se guarda como atributo
  public Acta generarActa(Materia materia) {
    // Enunciado 3
    return new Acta(materia);
  }

  public List<Materia> getMaterias() {
    return Collections.unmodifiableList(materias);
  }

  // Enunciado 6 inciso 4
  Carrera getCarrera() {
    return carrera;
  }

  // Enunciado 6 inciso 4
  void setCarrera(Carrera carrera) {
    this.carrera = carrera;
  }

  @Override
  public String toString() {
    return "Docente " + getNombre() + " (" + especialidad + ")";
  }
}

//---------------------------------------------------------
// Composición: Universidad -> Carrera
//---------------------------------------------------------
class Universidad {
  private final String nombre;
  private final List<Carrera> carreras = new ArrayList<>();

  public Universidad(String nombre) {
    this.nombre = nombre;
  }

  // Enunciado 5
  // La Universidad CREA a las partes (carreras: no existen fuera de la Universidad)
  public Carrera crearCarrera(String nombreCarrera) {
    // Enunciado 3
    Carrera d = new Carrera(nombreCarrera);
    carreras.add(d);
    return d;
  }

  public String getNombre() {
    return nombre;
  }

  public List<Carrera> getCarreras() {
    return Collections.unmodifiableList(carreras);
  }
}

//---------------------------------------------------------
// Agregación: Carrera -> Docente
//---------------------------------------------------------
class Carrera {
  private final String nombre;
  private final List<Docente> docentes = new ArrayList<>();

  Carrera(String nombre) {
    this.nombre = nombre;
  }

  // Enunciado 5
  // La Carrera AGREGA a las partes ya existentes
  public void agregarDocente(Docente docente) {
    // Enunciado 6 inciso 4
    if (docente.getCarrera() != null) {
      throw new IllegalStateException("El docente ya pertenece a una carrera");
    }
    // Enunciado 3
    docentes.add(docente);
    docente.setCarrera(this);
  }

  public String getNombre() {
    return nombre;
  }

  public List<Docente> getDocentes() {
    return Collections.unmodifiableList(docentes);
  }
}

//---------------------------------------------------------
// Composición: Materia -> Horario
//---------------------------------------------------------
class Materia {
  private final String codigo;
  private final int creditos;
  private Docente docente;
  private final List<Horario> horarios = new ArrayList<>();
  private final List<Inscripcion> inscripciones = new ArrayList<>();

  public Materia(String codigo, int creditos) {
    this.codigo = codigo;
    this.creditos = creditos;
  }

  public Horario agregarHorario(LocalDate fecha, String aula) {
    // Enunciado 3
    Horario s = new Horario(fecha, aula);
    horarios.add(s);
    return s;
  }

  void registrarInscripcion(Inscripcion inscripcion) {
    inscripciones.add(inscripcion);
  }

  void setDocente(Docente docente) {
    this.docente = docente;
  }

  public String getCodigo() {
    return codigo;
  }

  public int getCreditos() {
    return creditos;
  }

  public Docente getDocente() {
    return docente;
  }

  public List<Horario> getHorarios() {
    return Collections.unmodifiableList(horarios);
  }

  public List<Inscripcion> getInscripciones() {
    return Collections.unmodifiableList(inscripciones);
  }

  // Enunciado 6 inciso 5
  public static class Horario {
    private final LocalDate fecha;
    private final String aula;

    private Horario(LocalDate fecha, String aula) {
      this.fecha = fecha;
      this.aula = aula;
    }

    public LocalDate getFecha() {
      return fecha;
    }

    public String getAula() {
      return aula;
    }
  }
}

//---------------------------------------------------------
// Inscripcion implementa Calificable
// Asociación: el estudiante conoce sus inscripciones
// Asociación: la materia tiene sus inscripciones
//---------------------------------------------------------
interface Calificable {
  double calcularNota();
}

// Enunciado 3
class Inscripcion implements Calificable {
  private final Estudiante estudiante;
  private final Materia materia;
  private final LocalDate fecha;
  // Enunciado 6 inciso 3
  private Double nota;

  Inscripcion(Estudiante estudiante, Materia materia, LocalDate fecha) {
    this.estudiante = estudiante;
    this.materia = materia;
    this.fecha = fecha;
  }

  public void registrarNota(double nota) {
    if (nota < 0 || nota > 100) {
      throw new IllegalArgumentException("La nota debe estar entre 0 y 100");
    }
    this.nota = nota;
  }

  @Override
  // Enunciado 6 inciso 3
  public double calcularNota() {
    if (nota == null) {
      throw new IllegalStateException("La nota aún no fue registrada");
    }
    return nota;
  }

  public Estudiante getEstudiante() {
    return estudiante;
  }

  public Materia getMateria() {
    return materia;
  }

  public LocalDate getFecha() {
    return fecha;
  }
}

//---------------------------------------------------------
// Dependencia: Docente usa Acta de forma temporal
//---------------------------------------------------------
class Acta {
  private final LocalDate fecha = LocalDate.now();
  private final String contenido;

  Acta(Materia materia) {
    StringBuilder sb = new StringBuilder();
    sb.append("ACTA ").append(materia.getCodigo()).append(" - ").append(fecha).append('\n');
    for (Inscripcion i : materia.getInscripciones()) {
      // Enunciado 6 inciso 3
      String nota;
      try {
        nota = String.valueOf(i.calcularNota());
      } catch (IllegalStateException e) {
        nota = "sin nota";
      }
      sb.append("  ").append(i.getEstudiante().getNombre()).append(": ").append(nota).append('\n');
    }
    this.contenido = sb.toString();
  }

  @Override
  public String toString() {
    return contenido;
  }
}

/**
 * Sistema académico: ejemplo de relaciones entre clases en UML/Java.
 *
 */
public class SistemaAcademico {

  public static void main(String[] args) {
    // Enunciado 1
    // Composición: la Universidad crea sus Carreras
    Universidad umsa = new Universidad("UMSA");
    Carrera informatica = umsa.crearCarrera("Informática");

    // Agregación: los Docentes existen antes e independientemente de la Materia
    Docente docente = new Docente("Ana Alba", "1234567", "Ingeniería de Software");
    informatica.agregarDocente(docente);

    // Asociación: el Docente dicta una Materia
    Materia poo = new Materia("INF-121", 6);
    docente.dictar(poo);

    // Composición: la Materia crea sus Horarios
    poo.agregarHorario(LocalDate.of(2026, 07, 2), "Aula 101");
    poo.agregarHorario(LocalDate.of(2026, 07, 9), "Aula 101");

    // Asociación entre Estudiante e Inscripcion
    Estudiante e1 = new Estudiante("Carlos Flores", "7654321", "E-001");
    Estudiante e2 = new Estudiante("Maria Salas", "7654322", "E-002");
    Inscripcion i1 = e1.inscribirse(poo);
    Inscripcion i2 = e2.inscribirse(poo);
    i1.registrarNota(85);
    i2.registrarNota(92);

    // Herencia + polimorfismo
    List<Persona> personas = Arrays.asList(docente, e1, e2);
    personas.forEach(p -> System.out.println(p));

    // La inscripcion se usa a través de la interfaz Calificable
    Calificable c = i1;
    System.out.println("Nota de " + e1.getNombre() + ": " + c.calcularNota());

    // Dependencia: el Docente usa Acta solo dentro de un método
    Acta acta = docente.generarActa(poo);
    System.out.println(acta);

    // Enunciado 6 inciso 1
    try {
      e1.inscribirse(poo);
    } catch (IllegalStateException ex) {
      System.out.println("Enunciado 6 inciso 1: " + ex.getMessage());
    }

    // Enunciado 6 inciso 2
    Docente d2 = new Docente("Luis Rios", "1234568", "Redes");
    try {
      d2.dictar(poo);
    } catch (IllegalStateException ex) {
      System.out.println("Enunciado 6 inciso 2: " + ex.getMessage());
    }

    // Enunciado 6 inciso 3
    Materia poo2 = new Materia("INF-122", 4);
    Inscripcion sinNota = e1.inscribirse(poo2);
    try {
      sinNota.calcularNota();
    } catch (IllegalStateException ex) {
      System.out.println("Enunciado 6 inciso 3: " + ex.getMessage());
    }
    System.out.println(docente.generarActa(poo2));

    // Enunciado 6 inciso 4
    Carrera sistemas = umsa.crearCarrera("Sistemas");
    try {
      sistemas.agregarDocente(docente);
    } catch (IllegalStateException ex) {
      System.out.println("Enunciado 6 inciso 4: " + ex.getMessage());
    }

    // Enunciado 6 inciso 5
    System.out.println("Enunciado 6 inciso 5: horarios de " + poo.getCodigo() + " = " + poo.getHorarios().size());

    // Enunciado 7
    Ayudante ayudante = new Ayudante("Pedro Rojas", "7654323", "E-003", 20);
    ayudante.asignarMateria(poo);
    Persona persona = ayudante;
    System.out.println(persona);
    Estudiante comoEstudiante = ayudante;
    System.out.println("Código del ayudante: " + comoEstudiante.getCodigo());
    System.out.println("Materia del ayudante: " + ayudante.getMateria().getCodigo());
    System.out.println("Docente del ayudante: " + ayudante.getDocente());
  }
}