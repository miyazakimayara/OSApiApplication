/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.miyazaki.OSApiApplication.domain.repository;

import br.com.miyazaki.OSApiApplication.domain.model.OrdemServico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ppjatb
 */
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{
    OrdemServico findById(long id);
    
    @Override
    List<OrdemServico> findAll();
}
