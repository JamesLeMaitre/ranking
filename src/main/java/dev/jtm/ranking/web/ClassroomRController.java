package dev.jtm.ranking.web;

import dev.jtm.ranking.entities.Classroom;
import dev.jtm.ranking.services.ClassroomService;
import dev.jtm.ranking.utils.DataFormatter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/ranking/")
public class ClassroomRController extends DataFormatter<Classroom> {
    private final ClassroomService classroomService;


    @PostMapping("create")
    public Object create(@RequestBody() Classroom data){
        try {
            return  renderData(true, classroomService.create(data),"Create ");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return  renderStringData(false,"Error while processing" ,exceptionAsString);
        }
    }

    @GetMapping("list")
    public Object List(){
        try {
            List<Classroom> items = classroomService.getAll();
            return  renderDataArray(true,items,"list of element");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return  renderStringData(false,"Error while processing" ,exceptionAsString);
        }
    }

    @GetMapping("ranking")
    public Object rank(){
        try {
            classroomService.ranking();
            return  renderDataArrays(true, classroomService.ranking(),"list of element");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return  renderStringData(false,"Error while processing" ,exceptionAsString);
        }
    }
}
