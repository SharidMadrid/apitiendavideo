package apitiendavideo.tiendavideo.servicios;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import apitiendavideo.tiendavideo.interfaces.IEmpresaServicio;
import apitiendavideo.tiendavideo.modelos.Empresa;
import apitiendavideo.tiendavideo.modelos.Titulo;
import apitiendavideo.tiendavideo.repositorios.EmpresaRepositorio;

@Service
public class EmpresaServicio implements IEmpresaServicio {

    private EmpresaRepositorio repositorio;

    public void EmpresaRepositorio(EmpresaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Empresa> listar() {
        return repositorio.findAll();
    }

    @Override
    public Empresa obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Empresa> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return repositorio.save(empresa);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<Titulo> buscarTitulos(String nombre) {
        List<Titulo> titulos = em.createStoredProcedureQuery("fBuscarTitulosPorEmpresa", Titulo.class)
                .registerStoredProcedureParameter("nombreEmpresa", String.class, ParameterMode.IN)
                .setParameter("nombreEmpresa", nombre)
                .getResultList();

        return titulos;
    }

}
