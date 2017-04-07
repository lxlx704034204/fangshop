package com.fang.fangshop.core.freemarker;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by dylan on 15-1-26.
 */
public class MessageLoader {
    private MessageLoader(){
        init();
    }
    private static MessageLoader instance = null;
    public static MessageLoader instance(){
        if(instance == null){
            instance = new MessageLoader();
        }
        return instance;
    }

    public String getMessage(String key){
        if(resourceBundle == null){
            return key;
        }
        return resourceBundle.getString(key);
    }

    private ResourceBundle resourceBundle;


    public synchronized void init(){
        if(resourceBundle == null){
            resourceBundle = ResourceBundle.getBundle("i18n/jeeshop");
        }
    }

    /**
     * 国际化配置
     * Created by dylan on 15-1-15.
     */
    public static class I18N implements TemplateMethodModelEx {
        @Override
        public Object exec(List arguments) throws TemplateModelException {
            return instance().getMessage(arguments.get(0).toString());
        }

    }
}
