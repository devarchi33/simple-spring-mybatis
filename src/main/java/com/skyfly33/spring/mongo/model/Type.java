package com.skyfly33.spring.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

/**
 * Created by donghoon on 15. 8. 27..
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "types")
public class Type {

    @Id
    private String typeId;
    private String name;
    private String desc;
    private String extension;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Type{");
        builder.append("id: ").
                append(typeId).
                append(", name: ").
                append(name).append(", desc: ").
                append(desc).append(", extension: ").
                append(extension).
                append("}");
        return builder.toString();
    }
}
