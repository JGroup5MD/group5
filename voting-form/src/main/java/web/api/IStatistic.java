package web.api;

import java.util.List;

//мапа, которая считает голоса, она обращается к Vote, а Vote к своим Дао
public interface IStatistic {

    List getStatistic();
}
