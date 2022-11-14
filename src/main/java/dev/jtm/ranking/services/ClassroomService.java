package dev.jtm.ranking.services;

import dev.jtm.ranking.entities.Classroom;

import java.util.List;

public interface ClassroomService {
    Classroom create(Classroom classroom);
     List<Classroom> getAll();
    List<Classroom>[] ranking();
}
