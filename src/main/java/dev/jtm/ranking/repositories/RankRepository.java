package dev.jtm.ranking.repositories;

import dev.jtm.ranking.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RankRepository extends JpaRepository<Rank,Long> {

    @Query("select r from Rank r order by r.note desc ,r.firstname ")
    List<Rank> ranking();
}
