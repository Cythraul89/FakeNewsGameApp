package com.example.fakenewsquiz;

import java.util.ArrayList;
import java.util.List;

/* Database with all the questions stored */
public class QuestionDataBase
{
    static private QuestionDataBase instance;
    private List<Question> m_list;


    /* private for singleton */
    private QuestionDataBase ()
    {
        loadDataBase();
    }

    /* getInstance for singleton */
    public static QuestionDataBase getInstance () {
        if (QuestionDataBase.instance == null) {
            QuestionDataBase.instance = new QuestionDataBase ();
        }
        return QuestionDataBase.instance;
    }

    /* getter for questions */
    Question getQuestion(int id)
    {
        // wrap around mechanism.
        int pos= id % m_list.size();
        return m_list.get(pos);
    }

    /*
    * load all questions into the database
    *
    * todo should be on a remote source and within xml file
    *  */
    public void loadDataBase()
    {
        m_list = new ArrayList<Question>();
        m_list.add(
                new Question(
                0,
                "Exposing yourself to the sun or to temperatures higher than 25 degrees celsius does kill the coronavirus",
                "You can catch COVID-19, no matter how sunny or hot the weather is. Countries with hot weather have reported cases of COVID-19." +
                        "To protect yourself make sure you clean your hands frequently and thoroughly and avoid touching your eyes, mouth and nose.",
                "https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public/myth-busters",
                "false"
                )
        );
        m_list.add(
                new Question(
                        1,
                        "You can recover from the coronavirus disease (COVID-19). Catching the new coronavirus does not mean you will have it for life.",
                        "Most of the people who catch covid-19 can recover and eliminate the virus from their bodies"+
                                "If you catch the disease make sure you treat your symptoms. If you have cough, fever and difficulty breathing, seek medical care early." +
                                ", but call your health facility by telephone first if possible. Most patients recover thanks to supportive care.",
                        "https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public/myth-busters",
                        "true"
                )
        );

        m_list.add(
                new Question(
                        2,
                        "Being able to hold your breath for 10 seconds or more without coughing or feeling discomfort does mean you are free from the coronavirus disease (COVID-19)",
                        "The most common symptoms of COVID-19 are dry cough, tiredness and fever. Some people may develop more severe forms of the disease such as pneumonia."+
                                "The best way to confirm if you have the virus producing COVID-19 disease is with a laboratory test." +
                                "You cannot confirm it with this breathing exercise, which can even be dangerous.",
                        "https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public/myth-busters",
                        "false"
                )
        );

        m_list.add(
                new Question(
                        3,
                        "Drinking alcohol does protect you against the corona virus.",
                        "Frequent or excessive alcohol consumption can increase your risk of health problems" +
                                "Drinking alcohol does not protect you against COVID-19 and can be dangerous.",
                        "https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public/myth-busters",
                        "false"
                )
        );
    }
}
