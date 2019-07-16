package com.example.infoapp.features.Storage.Helpers;

import java.util.ArrayList;
import java.util.HashMap;

public class AnswerParser {

    public String parse(HashMap<String,String> answers, String previousAnswers){

        String parsedAnswers = "";
        for (String key: answers.keySet()) {
            parsedAnswers += key + ":" + answers.get(key) +",";
        }

        if (previousAnswers != null) parsedAnswers = previousAnswers + ";" + parsedAnswers;

        return parsedAnswers;
    }

    public ArrayList<HashMap<String,String>> parse(String answers){
        ArrayList<HashMap<String,String>> answersParsed = new ArrayList<>();

        String [] separatedAnswers = answers.split(";");
        for(int i = 0; i < separatedAnswers.length; i++){
            if(!separatedAnswers[i].equals("")){
                answersParsed.add(this.parseAnswer(separatedAnswers[i]));
            }
        }

        return answersParsed;
    }

    private HashMap<String,String> parseAnswer(String answers){

        HashMap<String,String> map = new HashMap<>();

        String [] separatedAnswers = answers.split(",");
        for (String answer: separatedAnswers) {
            if(answer != ""){
                String [] splitted = answer.split(":");
                map.put(splitted[0], splitted[1]);
            }
        }
        return map;
    }

}
