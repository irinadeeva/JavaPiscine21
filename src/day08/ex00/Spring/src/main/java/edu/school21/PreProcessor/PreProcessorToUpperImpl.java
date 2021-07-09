package edu.school21.PreProcessor;

import org.springframework.stereotype.Component;


@Component
public class PreProcessorToUpperImpl implements PreProcessor{
    public String changeString(String s){
        return s.toUpperCase();
    }
}
