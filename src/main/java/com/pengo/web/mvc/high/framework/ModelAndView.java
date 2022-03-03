package com.pengo.web.mvc.high.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengo
 * @description:
 * @date 2022/2/26 23:33
 */
public class ModelAndView {
    private Map<String,Object> model;
    private String view;

    public ModelAndView(String view) {
        this.view = view;
        this.model = Map.of();
    }

    public ModelAndView(String view, String name, Object value) {
        this.view = view;
        this.model = new HashMap<>();
        this.model.put(name, value);
    }

    public ModelAndView(String view, Map<String, Object> model) {
        this.view = view;
        this.model = new HashMap<>(model);
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
