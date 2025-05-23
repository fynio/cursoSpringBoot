package cursoSpringBoot.domain;


// CLASE TIPO POJO
// CLASE QUE REPRESENTA UN PRODUCTO
public class Product {
    private Integer id; // Atributo
    private String nombre; // Atributo
    private Double precio;   // Atributo
    private Integer stock;

    public Product(Integer id, String nombre, Double precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    
    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }




    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock()
    {
        return stock;
    }




    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}
