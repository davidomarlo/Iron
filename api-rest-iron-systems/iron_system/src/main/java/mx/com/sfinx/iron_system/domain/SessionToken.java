package mx.com.sfinx.iron_system.domain;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionToken implements Serializable {

    private static SessionToken instance;
    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private String expiresIn;

    @SerializedName("access_token")
    private String access_Token;


    @SerializedName("producto_id")
    private String producto_id;



    @SerializedName("modelo")
    private String modelo;



    @SerializedName("titulo")
    private String titulo;



    @SerializedName("precio_lista")
    private String precio_lista;



    @SerializedName("marca")
    private String marca;

    @SerializedName("productos de una marca")
    private String brand_name;

    public static SessionToken getInstance() {

        if (instance == null) {
            return instance = new SessionToken();

        }
        return instance;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getPrecio_lista() {
        return precio_lista;
    }

    public void setPrecio_lista(String precio_lista) {
        this.precio_lista = precio_lista;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(String producto_id) {
        this.producto_id = producto_id;
    }
    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAccess_Token() {
        return access_Token;
    }

    public void setAccess_Token(String access_Token) {
        this.access_Token = access_Token;
    }

}
