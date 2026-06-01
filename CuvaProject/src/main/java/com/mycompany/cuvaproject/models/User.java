package com.mycompany.cuvaproject.models;

public class User {
    private String name;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String post;

    // constructor

    public User(String name, String lastName, String username, String password, String email, String post) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.post = post;
        
        validated(); 
        System.out.println("se creo el objeto");


    }

    // getters

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPost() {
        return this.post;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPost(String post) {
        this.post = post;
    }

    // validations

    // validated name se usa para hacer todas las validaciones de el nombre de
    // usuario

    public void validated_name() {

        if (this.name == null || this.name.isEmpty()) {
            throw new IllegalArgumentException("el nombre no puede estar vacio");
        }

        for (int i = 0; i < this.name.length(); i++) {
            char c = this.name.charAt(i);

            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException(
                        "el nombre no puede tener numeros, caracteres especiales ni espacios");
            }
        }

        if (this.name.length() < 3) {
            throw new IllegalArgumentException("el nombre debe de tener un minimo de 3 caracteres");
        }
        if (this.name.length() > 20) {
            throw new IllegalArgumentException("el nombre puede tener un maximo de 20 caracteres ");
        }

    }

    // validated last_name son las validaciones de el apellido de el usuario

    public void validated_lastName() {

        for (int j = 0; j < this.lastName.length(); j++) {
            char a = this.lastName.charAt(j);

            if (!Character.isLetter(a)) {
                throw new IllegalArgumentException(
                        "el apellido no puede tener numeros, caracteres especiales ni espacios");
            }
        }

        if (this.lastName.length() < 3) {
            throw new IllegalArgumentException("el nombre y apellido deben de tener un minimo de 3 caracteres");
        }
        if (this.lastName.length() > 20) {
            throw new IllegalArgumentException("el apellido puede tener un maximo de 20 caracteres ");
        }

        if (this.lastName.isEmpty()) {
            throw new IllegalArgumentException("todos los campos deben ser llenados");
        }

    }

    // validated_username son las validaciones de el nombre de usuario

    public void validated_username() {

        if (this.username.isEmpty()) {
            throw new IllegalArgumentException("el nombre de usuario no puede estar vacio");
        }

        if (this.username.length() < 3) {
            throw new IllegalArgumentException("el nombre de usuario debe de tener un minimo de 3 caracteres");
        }
        if (this.username.length() > 30) {
            throw new IllegalArgumentException("el nombre de usuario debe de tener menos de 30 caracteres");
        }

    }

    // validated email son las validaciones de el correo de el usuario

    public void validated_email() {

        if (this.email.isEmpty()) {
            throw new IllegalArgumentException("todos los campos deben ser llenados");
        }
        if (!this.email.contains("@") || !this.email.contains(".")) {
            throw new IllegalArgumentException(
                    "el formato de correo es invalido. Debe de contener un punto (.) y un arroba (@)");
        }
    }

    // validated_password esta hecho para validar los parametros de la contrasena

    public void validated_password() {

        boolean upper = false;
        boolean digit = false;
        boolean characterSpecial = false;

        for (int i = 0; i < this.password.length(); i++) {
            char b = this.password.charAt(i);

            if (Character.isDigit(b)) {
                digit = true;
            }
            if (Character.isUpperCase(b)) {
                upper = true;
            }
            if (!Character.isLetter(b) && !Character.isDigit(b) && !Character.isSpaceChar(b)) {
                characterSpecial = true;
            }
        }
        if (characterSpecial == false || digit == false || upper == false) {
            throw new IllegalArgumentException(
                    " la contraseña debe tener como minimo una mayuscula, un caracter especial y un numero");
        }

        if (this.password.length() < 8) {
                throw new IllegalArgumentException("la contraseña debe tener como mínimo 8 caracteres");
        }

        if (this.password.isEmpty()) {
            throw new IllegalArgumentException("todos los campos deben ser llenados");
        }

        for (int j = 0; j < this.password.length(); j++) {
            char a = this.password.charAt(j);

            if (Character.isSpaceChar(a)) {
                throw new IllegalArgumentException("la contraseña no puede tener espacios en blanco");
            }
        }

        if (this.password.equals(this.username)) {
            throw new IllegalArgumentException("la contraseña no puede ser igual al nombre de usuario");
        }
    }

    // validated no es una validacion por si misma si no que agrupa todas las
    // validaciones anteriores para que las ejecute en conjuto al momento de usarlo

    public void validated() {

        validated_username();
        validated_name();
        validated_lastName();
        validated_email();
        validated_password();
    }
}