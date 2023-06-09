package apitiendavideo.tiendavideo.interfaces;

import java.util.List;

import apitiendavideo.tiendavideo.modelos.Pais;

public interface IPaisServicio {

    public List<Pais> listar();

    public Pais obtener(Long id);

    public List<Pais> buscar(String nombre);

    public Pais guardar(Pais pais);

    public boolean eliminar(Long id);

}
