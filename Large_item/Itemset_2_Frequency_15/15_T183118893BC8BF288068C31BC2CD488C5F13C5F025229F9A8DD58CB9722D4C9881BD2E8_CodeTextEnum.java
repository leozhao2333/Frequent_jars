package com.github.foxnic.api.constant;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.language.Lang;
import com.github.foxnic.api.language.SuperLanguageService;

public interface CodeTextEnum {


    String code();
    String name();
    String text();
    default String description() {
        return text();
    }

    /**
     * 此方法用于实现 在 CodeTextEnumUtil 中的默认实现
     * */
    default JSONObject toJSONObject(String languageContext) {
        JSONObject item = new JSONObject();
        item.put("name", this.name());
        item.put("code", this.code());
        item.put("text", Lang.translate(this.text(),null, languageContext));
        item.put("description", Lang.translate(this.description(),null, languageContext));
        return item;
    }

    default JSONObject toJSONObject() {
        return toJSONObject(SuperLanguageService.DEFAULT_CONTEXT);
    }

    /**
     * 是否在前端显示
     * */
    default boolean display() {
        return true;
    }

    public static CodeTextEnum parse(CodeTextEnum[] values,String code) {
        if(code==null) return null;
        code=code.trim();
        if(code.length()==0) return null;
        // 优先匹配代码
        for (CodeTextEnum value : values) {
            if(value.code().equals(code)) return value;
        }
        // 若代码未匹配则匹配 name
        for (CodeTextEnum value : values) {
            if(value.name().equals(code)) return value;
        }
        return null;
    }




}
