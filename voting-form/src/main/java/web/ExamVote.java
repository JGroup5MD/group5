package web;

public class ExamVote {
    VoteFormServlet singerName = new VoteFormServlet();
    VoteFormServlet genereName = new VoteFormServlet();
    private boolean examVote;

    public void exam (){
        if (singerName.getSingerName().length==1 &
                (genereName.getGenereList().length>3 & genereName.getGenereList().length<5)) {
            examVote = true;
        }

    }

    public boolean isExamVote() {
        return examVote;
    }
}
