package com.jennbowers.thymeleaffun.repositories;

import com.jennbowers.thymeleaffun.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
}
