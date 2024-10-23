package pe.edu.cibertec.alumno_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.alumno_backend.dto.BusquedaRequestDTO;
import pe.edu.cibertec.alumno_backend.service.BusquedaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class BusquedaServiceImpl implements BusquedaService {

        @Autowired
        ResourceLoader resourceLoader;

    @Override
    public String[] buscarAlumno(BusquedaRequestDTO busquedaRequestDTO) throws IOException {

    String[] datosAlumno = null;
    Resource resource = resourceLoader.getResource("classpath:alumno.txt");

    try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
        String linea;
        while ((linea = br.readLine())!=null){
         String[] datos= linea.split(";");
         if(busquedaRequestDTO.codigo().equals(datos[0])){
           datosAlumno = datos;
           break;
         }
        }
    }catch (IOException e){
        throw new IOException("Error archivo");
    }
    try{
        Thread.sleep(5000);
    }catch (InterruptedException e ){
        Thread.currentThread().interrupt();
    }
    return  datosAlumno;

    }
}
