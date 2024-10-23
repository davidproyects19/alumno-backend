package pe.edu.cibertec.alumno_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.alumno_backend.dto.BusquedaRequestDTO;
import pe.edu.cibertec.alumno_backend.dto.BusquedaResponseDTO;
import pe.edu.cibertec.alumno_backend.service.BusquedaService;

@RestController
@RequestMapping("/busqueda")
public class BusquedaController {

  @Autowired
  BusquedaService busquedaService;

@PostMapping("/buscar")
public BusquedaResponseDTO buscar(@RequestBody BusquedaRequestDTO busquedaRequestDTO){

    try {
        String[] datosAlumno=busquedaService.buscarAlumno(busquedaRequestDTO);
        if(datosAlumno == null){
            return new BusquedaResponseDTO("01","No se encontraron resultados","","","","");
        }
           return new BusquedaResponseDTO(datosAlumno[0],"Encontrado",datosAlumno[1],datosAlumno[2],datosAlumno[3],datosAlumno[4]);

    }catch (Exception e){
        System.out.println(e.getMessage());
        return new BusquedaResponseDTO("99","El servicio responde con un error HTTP","","","","");

    }
}

}
