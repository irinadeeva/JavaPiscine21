package edu.school21.Render;

import edu.school21.PreProcessor.PreProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RendererStandardImpl implements Renderer{
    @Qualifier("preProcessorToLowerImpl")
    @Autowired
    private PreProcessor preProcessor;

   public void print(String s){
       System.out.println(preProcessor.changeString(s));
   }
}
