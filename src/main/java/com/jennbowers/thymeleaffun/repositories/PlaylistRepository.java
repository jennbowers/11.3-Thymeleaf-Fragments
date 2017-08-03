package com.jennbowers.thymeleaffun.repositories;

import com.jennbowers.thymeleaffun.models.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
}
