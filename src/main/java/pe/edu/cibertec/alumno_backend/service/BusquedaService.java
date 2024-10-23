package pe.edu.cibertec.alumno_backend.service;

import pe.edu.cibertec.alumno_backend.dto.BusquedaRequestDTO;

import java.io.IOException;

public interface BusquedaService {

   String[] buscarAlumno(BusquedaRequestDTO busquedaRequestDTO) throws IOException;
}
