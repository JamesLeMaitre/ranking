package dev.jtm.ranking.controllers;

import dev.jtm.ranking.entities.Rank;
import dev.jtm.ranking.services.RankService;
import dev.jtm.ranking.utiles.DataFormatter;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@RestController
@RequestMapping("api/ranking/")
public class RankController extends DataFormatter<Rank> {
    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("getAll")
    public Object getAll() {
        try {
            List<Rank> items = rankService.getAll();
            return renderDataArray(true, items, "list of element");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return renderStringData(false, "Error while processing", exceptionAsString);
        }
    }

    @PostMapping("save")
    public Object save(@RequestBody Rank data) {
        try {
            Rank items = rankService.save(data);
            return renderData(true, items, "Save of element successful");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return renderStringData(false, "Error while processing", exceptionAsString);
        }
    }

    @GetMapping("ranking")
    public Object rankng() {
        try {
            List<Rank> items = rankService.ranking();
            return renderDataArray(true, items, "Ranking has benn done successfully !");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return renderStringData(false, "Error while processing", exceptionAsString);
        }
    }

}
