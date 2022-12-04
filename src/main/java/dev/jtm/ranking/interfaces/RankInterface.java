package dev.jtm.ranking.interfaces;

import dev.jtm.ranking.entities.Rank;

import java.util.List;

public interface RankInterface {
    List<Rank>  getAll();

    Rank save(Rank rank);

    List<Rank> ranking();


}
