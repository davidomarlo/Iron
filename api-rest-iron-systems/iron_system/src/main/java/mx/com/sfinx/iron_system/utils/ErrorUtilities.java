package mx.com.sfinx.iron_system.utils;

public enum  ErrorUtilities {

    Error01 (1, "Datos nulos"),
    Error02 (2, "Error al encontrar datos nulos");

    private final int code;
    private final String description;

    private ErrorUtilities(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }

}
