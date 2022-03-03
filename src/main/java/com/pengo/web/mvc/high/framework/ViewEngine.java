package com.pengo.web.mvc.high.framework;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ServletLoader;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.Writer;

/**
 * @author pengo
 * @description:
 * @date 2022/2/27 00:01
 */
public class ViewEngine {
    private final PebbleEngine engine;

    public ViewEngine(ServletContext context) {
        ServletLoader loader = new ServletLoader(context);
        loader.setCharset("UTF-8");
        loader.setPrefix("/WEB-INF/templates");
        loader.setSuffix("");
        this.engine = new PebbleEngine.Builder()
                .autoEscaping(true)
                .cacheActive(false)
                .loader(loader)
                .build();
    }

    public void render(ModelAndView mv, Writer writer)throws IOException {
        PebbleTemplate template = this.engine.getTemplate(mv.getView());
        template.evaluate(writer, mv.getModel());
    }
}
