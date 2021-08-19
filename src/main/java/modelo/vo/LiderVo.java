package modelo.vo;

public class LiderVo {

  private String nombre;
  private String primerApellido;
  private String segundoApellido;
  private Integer salario;
  private String ciudad;
  private String cargo;
  private Integer clasificacion;
  private Integer documento;
  private String fechaNacimiento;

  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getPrimerApellido() {
    return primerApellido;
  }
  public void setPrimerApellido(String primerApellido) {
    this.primerApellido = primerApellido;
  }
  public String getSegundoApellido() {
    return segundoApellido;
  }
  public void setSegundoApellido(String segundoApellido) {
    this.segundoApellido = segundoApellido;
  }
  public Integer getSalario() {
    return salario;
  }
  public void setSalario(Integer salario) {
    this.salario = salario;
  }
  public String getCiudad() {
    return ciudad;
  }
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }
  public String getCargo() {
    return cargo;
  }
  public void setCargo(String cargo) {
    this.cargo = cargo;
  }
  public Integer getClasificacion() {
    return clasificacion;
  }
  public void setClasificacion(Integer clasificacion) {
    this.clasificacion = clasificacion;
  }
  public Integer getDocumento() {
    return documento;
  }
  public void setDocumento(Integer documento) {
    this.documento = documento;
  }
  public String getFechaNacimiento() {
    return fechaNacimiento;
  }
  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  
}