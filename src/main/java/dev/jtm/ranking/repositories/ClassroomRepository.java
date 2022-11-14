package dev.jtm.ranking.repositories;

import dev.jtm.ranking.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
    @Query("select c.note,c.firstName,c.lastName from Classroom c order by c.note,c.firstName,c.lastName desc")
    List<Classroom>[] getAllNoteByAsc();
}
