package edu.school21.Printer;

import edu.school21.Render.Renderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PrinterWithPrefixImpl implements Printer{
    @Qualifier("rendererErrImpl")
    @Autowired
    private Renderer renderer;
    private final String PREFIX = "prefix ";

    @Bean(name = "printerWithPrefix")
    PrinterWithPrefixImpl getPrinterWithPrefix() {
        return new PrinterWithPrefixImpl();
    }

    @Override
    public void print(String s) {
        renderer.print(PREFIX + s);
    }
}
