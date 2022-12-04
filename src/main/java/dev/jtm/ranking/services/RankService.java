package dev.jtm.ranking.services;

import dev.jtm.ranking.entities.Rank;
import dev.jtm.ranking.interfaces.RankInterface;
import dev.jtm.ranking.repositories.RankRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class RankService implements RankInterface {
    private final RankRepository  rankRepository;

    public RankService(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    @Override
    public List<Rank> getAll() {
        return rankRepository.findAll();
    }

    @Override
    public Rank save(Rank rank) {
        return rankRepository.save(rank);
    }

    @Override
    public List<Rank> ranking() {
        return rankRepository.ranking();
    }


}
