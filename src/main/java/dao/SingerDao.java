package dao;

import dao.api.ISingerDao;
import dto.SingerDTO;

import java.util.ArrayList;
import java.util.List;

public class SingerDao implements ISingerDao {
    private  List<SingerDTO> singers= new ArrayList<>();

    public SingerDao(List<SingerDTO> singers) {
        this.singers = singers;
    }
    public  SingerDao() {
        this.singers.add(new SingerDTO(1,"Жанна Агузарова"));
        this.singers.add(new SingerDTO(2,"Земляне"));
        this.singers.add(new SingerDTO(3,"BTC"));
        this.singers.add(new SingerDTO(4,"Сосед с пианино сверху"));
        this.singers.add(new SingerDTO(5,"ДДТ"));
        this.singers.add(new SingerDTO(6,"Максим"));
        this.singers.add(new SingerDTO(7,"КиШ"));
        this.singers.add(new SingerDTO(8,"Маликов"));
        this.singers.add(new SingerDTO(9,"КИНО"));
        this.singers.add(new SingerDTO(10,"Ногу свело"));
    }

    @Override
    public List<SingerDTO> get() {
        return singers;
    }
}
