package saps;

public class Beneficiario {
    private int idBeneficiario;
    private String curp;
    private String nombre;
    private String apellido;
    private String direccion;
    private String municipio;

    public Beneficiario() {
    }

    public Beneficiario(String curp, String nombre, String apellido, String direccion, String municipio) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.municipio = municipio;
    }

    public Beneficiario(int idBeneficiario, String curp, String nombre, String apellido, String direccion, String municipio) {
        this.idBeneficiario = idBeneficiario;
        this.curp = curp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.municipio = municipio;
    }

    public int getIdBeneficiario() { 
        return idBeneficiario; 
    }
    
    public void setIdBeneficiario(int idBeneficiario) { 
        this.idBeneficiario = idBeneficiario; 
    }

    public String getCurp() { 
        return curp; 
    }
    
    public void setCurp(String curp) { 
        this.curp = curp; 
    }

    public String getNombre() { 
        return nombre;
    }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getApellido() { 
        return apellido; 
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido; 
    }

    public String getDirection() { 
        return direccion; 
    }
    
    public void setDireccion(String direccion) { 
        this.direccion = direccion; 
    }

    public String getMunicipio() {
        return municipio; 
    }
    
    public void setMunicipio(String municipio) { 
        this.municipio = municipio; 
    }
}