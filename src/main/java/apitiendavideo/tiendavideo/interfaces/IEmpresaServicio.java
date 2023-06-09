package apitiendavideo.tiendavideo.interfaces;

import java.util.List;
import apitiendavideo.tiendavideo.modelos.Empresa;
import apitiendavideo.tiendavideo.modelos.Titulo;

public interface IEmpresaServicio {

    public List<Empresa> listar();

    public Empresa obtener(Long id);

    public List<Empresa> buscar(String nombre);

    public List<Titulo> buscarTitulos(String nombre);

    public Empresa guardar(Empresa pais);

    public boolean eliminar(Long id);

}
