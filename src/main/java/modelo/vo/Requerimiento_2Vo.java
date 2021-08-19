package modelo.vo;

public class Requerimiento_2Vo {
    
    private Integer idProyecto;
    private String nombreMaterial;
    private Integer precioUnidad;

    public Integer getIdProyecto() {
        return idProyecto;
    }
    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }
    public String getNombreMaterial() {
        return nombreMaterial;
    }
    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }
    public Integer getPrecioUnidad() {
        return precioUnidad;
    }
    public void setPrecioUnidad(Integer precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
}
