package service;

import dao.api.IVoteDao;
import dto.SaveInformationDTO;
import dto.VoteDTO;
import service.api.IJenreService;
import service.api.ISingerService;
import service.api.IVoteService;

import java.util.Map;



public class VoteService implements IVoteService {
//___________________________________________________________________________________________________
//    private final IVoteDao dao;
//    private final ISingerService singerService;
//    private final IJenreService jenreService;
//
//    public VoteService(IVoteDao dao, ISingerService singerService, IJenreService jenreService) {
//        this.dao = dao;
//        this.singerService = singerService;
//        this.jenreService = jenreService;
//    }
//    @Override
//    public void save(VoteDTO vote) {
//        this.validate(vote);
//        SaveInformationDTO saveInformationDTO=new SaveInformationDTO(vote);
//        this.dao.save(saveInformationDTO);
//    }
//        private void validate(VoteDTO vote){
//            String singer = vote.getInformation();
//
//            if(singer == null || singer.isBlank()){
//                throw new IllegalArgumentException("Вы не выбрали артиста");
//            }
//
//            if(!this.singerService.equals(singer)){
//                throw new IllegalArgumentException("Такого артиста : " + singer + " не существует");
//            }
//
//            int[] jenres = vote.getIdJenres();
//
//            if(jenres == null){
//                throw new IllegalArgumentException("Вы не выбрали жанр");
//            }
//
//            if(jenres.length < 3 || jenres.length > 5){
//                throw new IllegalArgumentException("Количество выбранных жанров дожно быть 3 до 5");
//            }
//
//            for (int jenre : jenres) {
//                if(jenre == 0 ){
//                    throw new IllegalArgumentException("вы не выбрали жанр");
//                }
//
//                if(!this.jenreService.exist(" ")){
//                    throw new IllegalArgumentException("Такого жанра:  " + jenre + " не существует");
//                }
//            }
//            SingerDTO singerDTO=new SingerDTO(0 , " ");
//            JenreDTO jenreDTO=new JenreDTO(0, " ");
//            singerDTO.getSingerName();
//            jenreDTO.getJenreName();
//
//            Set<String> names = new HashSet<>();
//            names.addAll(Arrays.asList(Arrays.toString(jenres)));
//
//            if(jenres.length != names.size()){
//                throw new IllegalArgumentException("В вашем выборе есть одинаковые жанры");
//            }
//
//            String information = vote.getInformation();
//
//            if(information == null || information.isBlank()){
//                throw new IllegalArgumentException("О себе не передан");
//            }
//    }
//___________________________________________________________________________________________________
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


       Map<Integer, String> jenres = vote.getMapJenres();

        if(jenres == null){
            throw new IllegalArgumentException("Вы не сделали выбор");
        }

        if(jenres.size()< 3 || jenres.size() > 5){
            throw new IllegalArgumentException("Количество выбранных жанров дожно быть 3 до 5");
        }

        for (Map.Entry<Integer, String> jenre : jenres.entrySet()) {
            if(jenre.getValue() == null ){
                throw new IllegalArgumentException("Ыы не выбрали жанр");
            }

            if(!this.jenreService.exist(" ")){
                throw new IllegalArgumentException("Такого жанра:  " + jenre + " не существует");
            }
        }


        Map<Integer, String> singer = vote.getMapSinger();

        if(jenres == null){
            throw new IllegalArgumentException("Вы не сделали выбор");
        }

        if( jenres.size() > 1){
            throw new IllegalArgumentException("Выберите только одного актера");
        }

        for (Map.Entry<Integer, String> singers : singer.entrySet()) {
            if(singers.getValue() == null ){
                throw new IllegalArgumentException("вы не выбрали актера");
            }

            if(!this.singerService.exist(" ")){
                throw new IllegalArgumentException("Такого актера:  " + singers + " не существует");
            }
        }
//___________________________________________________________________________________________________
        String jenr = vote.getInformation();

        if(jenres == null){
            throw new IllegalArgumentException("Вы не выбрали жанр");
        }

        if(jenr.length()< 3 || jenr.length() > 5){
            throw new IllegalArgumentException("Количество выбранных жанров дожно быть 3 до 5");
        }


        String Singer = vote.getInformation();

        if(Singer == null || Singer.isBlank()){
            throw new IllegalArgumentException("Вы не выбрали артиста");
        }

        if(!this.singerService.equals(Singer)){
            throw new IllegalArgumentException("Такого артиста : " + Singer + " не существует");
        }
//___________________________________________________________________________________________________

        String information = vote.getInformation();

        if(information == null || information.isBlank()){
            throw new IllegalArgumentException("О себе не передан");
        }
//___________________________________________________________________________________________________
//        Set<String> names = new HashSet<>();
//        names.addAll(jenres.values());
//
//        if(jenres.size() != names.size()){
//            throw new IllegalArgumentException("В вашем выборе есть одинаковые жанры");
//        }
//___________________________________________________________________________________________________


    }
}
