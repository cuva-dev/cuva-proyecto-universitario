
 
package com.mycompany.cuvaproject.services;

import com.mycompany.cuvaproject.models.Reprobated;
import com.mycompany.cuvaproject.models.Student;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import com.mycompany.cuvaproject.models.Student;

public class ProcesadorRecord {

    
    public String obtenerTextoBruto(String rutaArchivo) {
        try (PDDocument document = Loader.loadPDF(new File(rutaArchivo))) {
            PDFTextStripper stripper = new PDFTextStripper();
            
           
            stripper.setSortByPosition(true);
            
            return stripper.getText(document);
        } catch (Exception e) {
            System.out.println("Error al leer el archivo PDF: " + e.getMessage());
            return "";
        }
    }

    /**
     * Método independiente que filtra el texto bruto, extrae los datos del alumno
     * y los empaqueta en una nueva instancia del objeto del modelo Student.
     */
    public Student extraerEstudiante(String textoBruto) {
        String textoNorm = textoBruto.replaceAll("\\s+", " ");
        
        String name = "No encontrado";
        String lastName = "No encontrado";
        String career = "No encontrado";
        String tuition = "No encontrado";
        int idInt = 0;

        Matcher mApell = Pattern.compile("Apellidos:\\s*(.*?)\\s*(?=Nombres|Matr[ií]cula|Documento|Carrera|Per[ií]odo|P[áa]gina|Identidad|V-|$)", Pattern.CASE_INSENSITIVE).matcher(textoNorm);
        if (mApell.find()) lastName = mApell.group(1).trim();

        Matcher mNomb = Pattern.compile("Nombres:\\s*(.*?)\\s*(?=Apellidos|Matr[ií]cula|Documento|Carrera|Per[ií]odo|P[áa]gina|Identidad|V-|$)", Pattern.CASE_INSENSITIVE).matcher(textoNorm);
        if (mNomb.find()) name = mNomb.group(1).trim();

        Matcher mCed = Pattern.compile("Identidad:\\s*V?-?\\s*(\\d+)", Pattern.CASE_INSENSITIVE).matcher(textoNorm);
        if (mCed.find()) {
            try { idInt = Integer.parseInt(mCed.group(1).trim()); } catch (Exception e) { idInt = 0; }
        }

        Matcher mCarr = Pattern.compile("Carrera:\\s*(.*?)\\s*(?=Apellidos|Nombres|Matr[ií]cula|Documento|Per[ií]odo|P[áa]gina|Identidad|V-|REP|MINISTERIO|UNEFA|CINU|\\b\\d|$)", Pattern.CASE_INSENSITIVE).matcher(textoNorm);
        if (mCarr.find()) career = mCarr.group(1).trim();

        Matcher mMat = Pattern.compile("Matr[ií\\S]cula:\\s*([0-9-]+)", Pattern.CASE_INSENSITIVE).matcher(textoNorm);
        if (mMat.find()) tuition = mMat.group(1).trim();

        return new Student(name, lastName, career, idInt, tuition);
    }

    /**
     * Orquesta la visualización de los datos procesados en la consola.
     */
    public void procesarYMostrarModelos(String textoBruto, Student estudianteObjeto) {
        System.out.println("====================================================================");
        System.out.println(" CONFIRMACIÓN DE EXTRACCIÓN AL MODELO DE BASE DE DATOS");
        System.out.println("====================================================================");

        String textoNorm = textoBruto.replaceAll("\\s+", " ");
        String name = "No encontrado", lastName = "No encontrado", career = "No encontrado", tuition = "No encontrado";
        int idInt = 0;

        Matcher mApell = Pattern.compile("Apellidos:\\s*(.*?)\\s*(?=Nombres|Matr[ií]cula|Documento|Carrera|Per[ií]odo|P[áa]gina|Identidad|V-|$)", Pattern.CASE_INSENSITIVE).matcher(textoNorm);
        if (mApell.find()) lastName = mApell.group(1).trim();

        Matcher mNomb = Pattern.compile("Nombres:\\s*(.*?)\\s*(?=Apellidos|Matr[ií]cula|Documento|Carrera|Per[ií]odo|P[áa]gina|Identidad|V-|$)", Pattern.CASE_INSENSITIVE).matcher(textoNorm);
        if (mNomb.find()) name = mNomb.group(1).trim();

        Matcher mCed = Pattern.compile("Identidad:\\s*V?-?\\s*(\\d+)", Pattern.CASE_INSENSITIVE).matcher(textoNorm);
        if (mCed.find()) { try { idInt = Integer.parseInt(mCed.group(1).trim()); } catch (Exception e) {} }

        Matcher mCarr = Pattern.compile("Carrera:\\s*(.*?)\\s*(?=Apellidos|Nombres|Matr[ií]cula|Documento|Per[ií]odo|P[áa]gina|Identidad|V-|REP|MINISTERIO|UNEFA|CINU|\\b\\d|$)", Pattern.CASE_INSENSITIVE).matcher(textoNorm);
        if (mCarr.find()) career = mCarr.group(1).trim();

        Matcher mMat = Pattern.compile("Matr[ií\\S]cula:\\s*([0-9-]+)", Pattern.CASE_INSENSITIVE).matcher(textoNorm);
        if (mMat.find()) tuition = mMat.group(1).trim();

        System.out.println("[NUEVO OBJETO -> STUDENT]");
        System.out.println("  • Nombres:   \"" + name + "\"");
        System.out.println("  • Apellidos: \"" + lastName + "\"");
        System.out.println("  • Carrera:   \"" + career + "\"");
        System.out.println("  • Cédula:    " + idInt);
        System.out.println("  • Matrícula: \"" + tuition + "\"");
        System.out.println();

        // Extraemos e imprimimos el listado de reprobados real
        List<Reprobated> reprobadas = extraerMateriasReprobadas(textoBruto);
        
        System.out.println("[NUEVOS OBJETOS -> REPROBATED] -> Total Encontrados: " + reprobadas.size());
        System.out.println("====================================================================");
    }

    /**
     * Analiza el historial académico extrayendo exclusivamente las materias reprobadas.
     */
    public List<Reprobated> extraerMateriasReprobadas(String textoBruto) {
        List<Reprobated> listaReprobadas = new ArrayList<>();
        String textoNorm = textoBruto.replaceAll("\\s+", " ");
        
        // Dividimos el contenido lineal usando los identificadores de periodos como bandera de inicio de fila
        String[] bloques = textoNorm.split("(?=\\b\\d[A-Z]*-\\d{4}\\b)");

        for (String bloque : bloques) {
            /* * MODIFICACIÓN DE SEGURIDAD REFORZADA:
             * Agregamos límites estrictos de palabra (\\b) para evitar que subcadenas 
             * dentro de descriptores de periodo intensivo (como 1PIV-2023) muten en códigos.
             */
            Pattern patronCodigo = Pattern.compile("\\b([A-Z]{3,4}-?\\d{4,5})\\b");
            Matcher m = patronCodigo.matcher(bloque);

            if (m.find()) {
                String code = m.group(1);

                // ESCUDO TOTAL CONTRA PERÍODOS INTRUSOS: Si el código es en realidad un año de periodo, lo saltamos
                if (code.contains("2022") || code.contains("2023") || code.contains("2024") || code.contains("2025") || code.contains("2026")) {
                    continue; 
                }

                String resto = bloque;

                // Capturamos el PERIODO
                String period = "Desconocido";
                Matcher mPeriodo = Pattern.compile("\\b\\d[A-Z]*-\\d{4}\\b").matcher(resto);
                if (mPeriodo.find()) {
                    period = mPeriodo.group();
                }

                // Capturamos el SEMESTRE
                String semester = "00";
                Matcher mSem = Pattern.compile("\\b(0[1-9]|1[0-2])\\b").matcher(resto);
                if (mSem.find()) {
                    semester = mSem.group(1);
                }

                // Pelamos la cebolla: removemos metadatos estructurales de la cadena de análisis
                resto = resto.replace(code, "");
                resto = resto.replaceFirst("\\b\\d[A-Z]*-\\d{4}\\b", "");
                resto = resto.replaceFirst("\\b(0[1-9]|1[0-2])\\b", "");

                // Evaluamos si el bloque contiene texto explícito de aplazamiento antes de limpiar la cadena
                boolean reproboPorTexto = resto.toUpperCase().matches(".*(REPROB[OÓ\\S]*|INASISTENCIA).*");

                /* * CORRECCIÓN PARA FILTRADO DE NOMBRE:
                 * Si el bloque contiene palabras de estado académico (REPROBÓ, APROBÓ, etc.), 
                 * cortamos la cadena allí para impedir fugas extrañas ("POR DE", "% DE") en el nombre.
                 */
                String restoUpper = resto.toUpperCase();
                int idxCorte = Integer.MAX_VALUE;
                String[] keywordsCorte = {"REPROB", "APROB", "INASISTENCIA", "ÍNDICE", "INDICE", "PÁGINA", "PAGINA", "MATRICULA"};
                for (String kw : keywordsCorte) {
                    int idx = restoUpper.indexOf(kw);
                    if (idx != -1 && idx < idxCorte) {
                        idxCorte = idx;
                    }
                }
                if (idxCorte != Integer.MAX_VALUE) {
                    resto = resto.substring(0, idxCorte);
                }

                // Rescatamos los dígitos restantes (calificación numérica real de la fila)
                Matcher mNum = Pattern.compile("\\b(\\d+)\\b").matcher(resto);
                List<Integer> numeros = new ArrayList<>();
                while (mNum.find()) {
                    numeros.add(Integer.parseInt(mNum.group(1)));
                }

                // Removemos los números remanentes para aislar únicamente el nombre de la asignatura
                resto = resto.replaceAll("\\b(\\d+)\\b", "");
                String nameSubject = resto.replaceAll("[^a-zA-ZÑÁÉÍÓÚñáéíóúIIVX1-9 ]", "").replaceAll("\\s+", " ").trim();
                if (nameSubject.isEmpty()) nameSubject = "Materia Desconocida";

                // Evaluamos el primer número capturado como la nota definitiva
                int calificacion = -1;
                if (!numeros.isEmpty()) {
                    calificacion = numeros.get(0); 
                }

                // Evaluación unificada de reprobación académica (Nota menor a 10 o Sanción por inasistencia)
                boolean esReprobada = (calificacion >= 0 && calificacion < 10) || reproboPorTexto;
                
                if (esReprobada) {
                    String notaFinal;
                    String observacion;
                    
                    if (calificacion >= 0 && calificacion < 10) {
                        notaFinal = String.format("%02d", calificacion);
                        observacion = "APLAZADO";
                    } else {
                        notaFinal = "REPROBÓ";
                        observacion = "Por Texto/Inasistencia";
                    }
                    
                    // Instanciamos el objeto con la firma del modelo
                    Reprobated materiaAplazada = new Reprobated(period, semester, code, nameSubject, notaFinal, observacion);
                    listaReprobadas.add(materiaAplazada);

                    // Muestra la confirmación en consola
                    System.out.println("  -> [" + period + "] " + code + " - " + nameSubject + " | Nota: " + notaFinal);
                }
            }
        }
        return listaReprobadas;
        
        
    }

    public void resultado(String rutaArchivo) {
        System.out.println(" Iniciando flujo automatizado para: " + rutaArchivo);
        
        String textoBrutoReal = obtenerTextoBruto(rutaArchivo);
        if (textoBrutoReal == null || textoBrutoReal.trim().isEmpty()) {
            System.err.println(" El texto extraído está vacío. Abortando análisis.");
            return;
        }
        Student estudianteDetectado = extraerEstudiante(textoBrutoReal);       
        procesarYMostrarModelos(textoBrutoReal, estudianteDetectado);
        
    }
    
}