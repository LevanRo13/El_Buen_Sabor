package com.project.El_Buen_Sabor.services.ArticuloManufacturadoService;

import com.project.El_Buen_Sabor.entities.ArticuloInsumo;
import com.project.El_Buen_Sabor.entities.ArticuloManufacturado;
import com.project.El_Buen_Sabor.entities.DetalleArticuloManufacturado;
import com.project.El_Buen_Sabor.repositories.ArticuloManufacturadoRepository;
import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }

    @Override
    public List<ArticuloManufacturado> buscarPorFiltro(String filtro) {
        return articuloManufacturadoRepository.search(filtro);
    }


    @Override
    public Page<ArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.search(filtro, pageable);
            return articuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Object[]> RankingArticuloManufacturado(Date fechaInicio, Date fechaFin) throws Exception {
        try {
            List<Object[]> articuloManufacturados = articuloManufacturadoRepository.RankingArticuloManufacturado(fechaInicio, fechaFin);
            return articuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}




