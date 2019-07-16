package com.example.infoapp.features.Storage.Helpers;

import java.util.ArrayList;
import java.util.HashMap;

public class AnswerParser {

    public String parse(final HashMap<String,String> answers, final String previousAnswers){

        String parsedAnswers = "";
        for (String key: answers.keySet()) {
            parsedAnswers += key + ":" + answers.get(key) +",";
        }

        if (previousAnswers != null) parsedAnswers = previousAnswers + ";" + parsedAnswers;

        return parsedAnswers;
    }

    public ArrayList<HashMap<String,String>> parse(String answers){
        final ArrayList<HashMap<String,String>> answersParsed = new ArrayList<>();

        final String [] separatedAnswers = answers.split(";");
        for(int i = 0; i < separatedAnswers.length; i++){
            if(!separatedAnswers[i].equals("")){
                answersParsed.add(this.parseAnswer(separatedAnswers[i]));
            }
        }

        return answersParsed;
    }

    private HashMap<String,String> parseAnswer(String answers){

        final HashMap<String,String> map = new HashMap<>();

        final String [] separatedAnswers = answers.split(",");
        for (final String answer: separatedAnswers) {
            if(!answer.equals("")){
                final String [] splitted = answer.split(":");
                map.put(splitted[0], splitted[1]);
            }
        }
        return map;
    }

}
