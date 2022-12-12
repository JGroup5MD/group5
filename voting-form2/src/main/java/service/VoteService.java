package service;

import dao.api.IVoteDao;
import dto.JenreDTO;
import dto.SaveInformationDTO;
import dto.SingerDTO;
import dto.VoteDTO;
import service.api.IJenreService;
import service.api.ISingerService;
import service.api.IVoteService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class VoteService implements IVoteService {
    private final IVoteDao dao;
    private final ISingerService singerService;
    private final IJenreService jenreService;

    public VoteService(IVoteDao dao, ISingerService singerService, IJenreService jenreService) {
        this.dao = dao;
        this.singerService = singerService;
        this.jenreService = jenreService;
    }
    @Override
    public void save(VoteDTO vote) {
        this.validate(vote);
        SaveInformationDTO saveInformationDTO=new SaveInformationDTO(vote);
        this.dao.save(saveInformationDTO);
    }
        private void validate(VoteDTO vote){
            String singer = vote.getInformation();

            if(singer == null || singer.isBlank()){
                throw new IllegalArgumentException("Вы не выбрали артиста");
            }

            if(!this.singerService.equals(singer)){
                throw new IllegalArgumentException("Такого артиста : " + singer + " не существует");
            }

            int[] jenres = vote.getIdJenres();

            if(jenres == null){
                throw new IllegalArgumentException("Вы не выбрали жанр");
            }

            if(jenres.length < 3 || jenres.length > 5){
                throw new IllegalArgumentException("Количество выбранных жанров дожно быть 3 до 5");
            }

            for (int jenre : jenres) {
                if(jenre == 0 ){
                    throw new IllegalArgumentException("вы не выбрали жанр");
                }

                if(!this.jenreService.exist(" ")){
                    throw new IllegalArgumentException("Такого жанра:  " + jenre + " не существует");
                }
            }
            SingerDTO singerDTO=new SingerDTO(0 , " ");
            JenreDTO jenreDTO=new JenreDTO(0, " ");
            singerDTO.getSingerName();
            jenreDTO.getJenreName();

            Set<String> names = new HashSet<>();
            names.addAll(Arrays.asList(Arrays.toString(jenres)));

            if(jenres.length != names.size()){
                throw new IllegalArgumentException("В вашем выборе есть одинаковые жанры");
            }

            String information = vote.getInformation();

            if(information == null || information.isBlank()){
                throw new IllegalArgumentException("О себе не передан");
            }
    }
}
