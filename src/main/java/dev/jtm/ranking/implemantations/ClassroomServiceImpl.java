package dev.jtm.ranking.implemantations;

import dev.jtm.ranking.entities.Classroom;
import dev.jtm.ranking.repositories.ClassroomRepository;
import dev.jtm.ranking.services.ClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;

    @Override
    public Classroom create(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> getAll() {
        return classroomRepository.findAll();
    }

    public static void tri_insertion(double tab[])
    {
        int taille = tab.length;

        for (int i = 1; i < taille; i++)
        {
            double index = tab[i];
            int j = i-1;

            while(j >= 0 && tab[j] > index)
            {
                tab[j+1] = tab[j];
                j--;
            }
            tab[j+1] = index;
        }
    }

    static void displayTab(double[] tab)
    {
        for(int i=0; i < tab.length; i++)
        {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    @Override
    public List<Classroom>[] ranking() {
        List<Classroom>[] data = classroomRepository.getAllNoteByAsc();
        return data;
    }
}
