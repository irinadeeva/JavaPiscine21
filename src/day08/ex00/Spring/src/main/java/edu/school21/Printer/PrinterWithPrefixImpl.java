package edu.school21.Printer;

import edu.school21.Render.Renderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class PrinterWithPrefixImpl implements Printer {

    String prefix;
    Renderer renderer;

    public PrinterWithPrefixImpl(String prefix, Renderer renderer) {
        this.prefix = prefix;
        this.renderer = renderer;
    }

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String message) {
        renderer.print(prefix + " " + message);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}