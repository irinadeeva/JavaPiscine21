package edu.school21.PreProcessor;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PreProcessorToLowerImpl implements PreProcessor{

    public String changeString(String s){
        return s.toLowerCase();
    }
}
