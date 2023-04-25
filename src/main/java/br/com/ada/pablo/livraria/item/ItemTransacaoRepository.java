package br.com.ada.pablo.livraria.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTransacaoRepository extends JpaRepository<ItemTransacao, Long> {
}
