package edu.school21.Printer;

import edu.school21.Render.Renderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PrinterWithDateTimeImpl implements Printer {

    @Qualifier("rendererStandardImpl")
    @Autowired
    private Renderer renderer;
    private LocalDateTime localDateTime = LocalDateTime.now();

    @Bean(name = "printerDateTime")
    PrinterWithDateTimeImpl getPrinterWithPrefix() {
        return new PrinterWithDateTimeImpl();
    }

    @Override
    public void print(String s) {
        renderer.print(localDateTime + " " + s);
    }
}
