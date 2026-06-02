package com.mycompany.cuvaproject.models;

public class User {
    private String name;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String post;

    // Constructor
    public User(String name, String lastName, String username, String password, String email, String post) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.post = post;
        
        // Validamos todo al crear el objeto
        validated(); 
        System.out.println("Se creo el objeto usuario con exito.");
    }

    // Getters
    public String getName() { return this.name; }
    public String getLastName() { return this.lastName; }
    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public String getEmail() { return this.email; }
    public String getPost() { return this.post; }

    // Setters con validación integrada para evitar datos corruptos después
    public void setName(String name) {
        this.name = name;
        validated_name();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        validated_lastName();
    }

    public void setUsername(String username) {
        this.username = username;
        validated_username();
    }

    public void setPassword(String password) {
        this.password = password;
        validated_password();
    }

    public void setEmail(String email) {
        this.email = email;
        validated_email();
    }

    public void setPost(String post) {
        this.post = post;
    }

    // --- VALIDACIONES CORREGIDAS ---

    public void validated_name() {
        if (this.name == null || this.name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if (this.name.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener un minimo de 3 caracteres");
        }
        if (this.name.length() > 20) {
            throw new IllegalArgumentException("El nombre puede tener un maximo de 20 caracteres");
        }
        for (int i = 0; i < this.name.length(); i++) {
            char c = this.name.charAt(i);
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException("El nombre no puede tener numeros, caracteres especiales ni espacios");
            }
        }
    }

    public void validated_lastName() {
        // CORREGIDO: Validación de vacío al principio para evitar NullPointerException
        if (this.lastName == null || this.lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacio");
        }
        if (this.lastName.length() < 3) {
            throw new IllegalArgumentException("El apellido debe tener un minimo de 3 caracteres");
        }
        if (this.lastName.length() > 20) {
            throw new IllegalArgumentException("El apellido puede tener un maximo de 20 caracteres");
        }
        for (int j = 0; j < this.lastName.length(); j++) {
            char a = this.lastName.charAt(j);
            if (!Character.isLetter(a)) {
                throw new IllegalArgumentException("El apellido no puede tener numeros, caracteres especiales ni espacios");
            }
        }
    }

    public void validated_username() {
        if (this.username == null || this.username.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacio");
        }
        if (this.username.length() < 3) {
            throw new IllegalArgumentException("El nombre de usuario debe tener un minimo de 3 caracteres");
        }
        if (this.username.length() > 30) {
            throw new IllegalArgumentException("El nombre de usuario debe tener menos de 30 caracteres");
        }
    }

    public void validated_email() {
        if (this.email == null || this.email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo electronico no puede estar vacio");
        }
        if (!this.email.contains("@") || !this.email.contains(".")) {
            throw new IllegalArgumentException("El formato de correo es invalido. Debe contener un punto (.) y un arroba (@)");
        }
    }

    public void validated_password() {
        // CORREGIDO: Validar vacío al principio
        if (this.password == null || this.password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacia");
        }
        if (this.password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener como mínimo 8 caracteres");
        }
        if (this.password.equals(this.username)) {
            throw new IllegalArgumentException("La contraseña no puede ser igual al nombre de usuario");
        }

        boolean upper = false;
        boolean digit = false;
        boolean characterSpecial = false;

        for (int i = 0; i < this.password.length(); i++) {
            char b = this.password.charAt(i);

            if (Character.isSpaceChar(b)) {
                throw new IllegalArgumentException("La contraseña no puede tener espacios en blanco");
            }
            if (Character.isDigit(b)) {
                digit = true;
            }
            if (Character.isUpperCase(b)) {
                upper = true;
            }
            if (!Character.isLetter(b) && !Character.isDigit(b)) {
                characterSpecial = true;
            }
        }

        if (!characterSpecial || !digit || !upper) {
            throw new IllegalArgumentException("La contraseña debe tener como minimo una mayuscula, un caracter especial y un numero");
        }
    }

    // Agrupador de validaciones
    public void validated() {
        validated_username();
        validated_name();
        validated_lastName();
        validated_email();
        validated_password();
    }
}