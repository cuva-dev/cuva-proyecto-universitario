package com.mycompany.cuvaproject.models;

public class Subject {
    private String code;
    private int semester;
    private int unit_credit;
    private String name;
    
    
    public Subject(String code, int semester, int Unit_credit, String name){
        
        this.code = code;
        this.unit_credit= Unit_credit;
        this.semester = semester;
        this.name = name;
    }
    
    //getters
    public String getCode(){return this.code;}
    public int getSemester(){return this.semester;}
    public int getUnit_credit(){return this.unit_credit;}
    public String getName(){return this.name;}
    
    //setters
    public void setCode(String code){this.code = code;}
    public void setSemester(int semester){this.semester = semester;}
    public void setUnit_credit(int unit_credit){this.unit_credit = unit_credit;}
    public void setName(String name){this.name = name;}
    
    //validations
    
    // validations of code
    public void validated_code(){
        
        if (this.code.isEmpty()){throw new IllegalArgumentException("el codigo no puede estar vacio");}
        if (this.code.contains(" ")){throw new IllegalArgumentException("el codigo no puede tener espaacios en blanco");}
        if(this.code.length() > 12 ||this.code.length() < 8)
            throw new IllegalArgumentException("el codigo debe de tener un tamaño entre 12 y 8 caracteres ");
        }
    
    // validations of semester
    public void validated_semester(){
        if(this.semester >99 || this.semester <1){
            throw new IllegalArgumentException("el numero de el semestre no es valido.");
        }
    }
    
    // validations of unit_credits
    public void validated_unit_credits(){
        if(this.unit_credit >99 || this.unit_credit <1){
            throw new IllegalArgumentException("el numero de las unidades de credito no es valida.");
        }
        
    }
    
    // validations of name
    
    public void validated_name(){
        if(this.name.isEmpty()){throw new IllegalArgumentException("el nombre no puede estar vacio");}
        
        if(this.name.length()> 25 || this.name.length()<3){
            throw new IllegalArgumentException("el nombre debe de tener un tamaño entre entre 3 y 25 caracteres");
        }
        
        for(int i = 0; i<this.name.length() ;i++){
            char c = this.name.charAt(i);
            if(!Character.isLetter(c) && !Character.isWhitespace(c)){
                throw new IllegalArgumentException("el nombre solo puede contener letras y espacios");
            }
        }
        
    }
    //validation general
    public void validated(){
        validated_name();
        validated_unit_credits();
        validated_semester();
        validated_code();
        }
}