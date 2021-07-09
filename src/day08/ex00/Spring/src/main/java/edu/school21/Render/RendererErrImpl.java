package edu.school21.Render;

import edu.school21.PreProcessor.PreProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RendererErrImpl implements Renderer{
    @Qualifier("preProcessorToUpperImpl")
    @Autowired
    private PreProcessor preProcessor;

    public void print(String s){
        System.err.println(preProcessor.changeString(s));
    }
}
