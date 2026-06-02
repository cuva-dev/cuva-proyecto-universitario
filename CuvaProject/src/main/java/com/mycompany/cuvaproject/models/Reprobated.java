package com.mycompany.cuvaproject.models;

/**
 *
 * @author FFIT221 mmmmmmmmmmmmmmmmmmm
 */
public class Reprobated {

    private String nameStudent;
    private String nameSubject;
    private String IDStudent;
    private String codeSubject;

    public Reprobated(String nameStudent, String nameSubject, String IDStudent, String codeSubject) {
        this.IDStudent = IDStudent;
        this.codeSubject = codeSubject;
        this.nameStudent = nameStudent;
        this.nameSubject = nameSubject;
    }

    //seeters and getters
    
    public String getIDStudent() {return IDStudent;}

    public void setIDStudent(String IDStudent) {this.IDStudent = IDStudent;}

    public String getNameSubject() {return nameSubject;}

    public void setNameSubject(String nameSubject) {this.nameSubject = nameSubject;}

    public String getNameStudent() {return nameStudent;}

    public void setNameStudent(String nameStudent) {this.nameStudent = nameStudent;}

    public String getCodeSubject() {return codeSubject;}

    public void setCodeSubject(String codeSubject) {this.codeSubject = codeSubject;}

    //validations
    
    public void validate_IDStudent() {
        if(this.IDStudent.length() > 10 || this.IDStudent.length()< 9 ){
            throw new IllegalArgumentException("la cedula es demasiada larga o demasiada corta");
        }
    }
    
    public void validate_codeSubject(){
        if (this.codeSubject.isEmpty()){throw new IllegalArgumentException("el codigo no puede estar vacio");}
        if (this.codeSubject.contains(" ")){throw new IllegalArgumentException("el codigo no puede tener espaacios en blanco");}
        if(this.codeSubject.length() > 12 ||this.codeSubject.length() < 8){throw new IllegalArgumentException("el codigo debe de tener un tamaño entre 12 y 8 caracteres ");}
    }
    
    public void validated_nameStudent(){
    
        if (nameStudent == null || nameStudent.isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío");}
        
        if (!nameStudent.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("El nombre solo puede contener letras");
        }
        if (nameStudent.length() < 2 || nameStudent.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener entre 2 y 50 caracteres");
            }
        if (nameStudent.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede contener números");
        }   
    }
    
    public void validated_nameSubject(){
    
        if(this.nameSubject.isEmpty()){throw new IllegalArgumentException("el nombre no puede estar vacio");}
        
        if(this.nameSubject.length()> 25 || this.nameSubject.length()<3){
            throw new IllegalArgumentException("el nombre debe de tener un tamaño entre entre 3 y 25 caracteres");
        }
        
        for(int i = 0; i<this.nameSubject.length() ;i++){
            char c = this.nameSubject.charAt(i);
            if(!Character.isLetter(c) && !Character.isWhitespace(c)){
                throw new IllegalArgumentException("el nombre solo puede contener letras y espacios");
            }
        }
    
    }
    
    //validation general
    
    public void validated(){
    
    validated_nameSubject();
    validated_nameStudent();
    validate_codeSubject();
    validate_IDStudent();
        
    }
    
}