package sistemadeventas.modelo;

public class login {

    private int id;
    private String nombre;
    private String email;
    private String pass;
    private String rol;

    public login() {
    }

    public login(int id, String nombre, String email, String pass, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
