package com.example.message;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long>  {

    Optional<MessageEntity> findByPrijemca(Long prijemca);
}

