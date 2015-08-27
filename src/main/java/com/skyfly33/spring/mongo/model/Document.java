package com.skyfly33.spring.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by donghoon on 15. 8. 27..
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "docs") // 컬렉션에 저장될 도메인 객체 식별.
public class Document {

    @Id //저장된 객체를 식별.
    private String documentId;
    private String name;

    @DBRef // 다른 컬렉션에 대한 레퍼런스 추가.
    private Type type;
    private String location;
    private String description;
    private Date created;
    private Date modified;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Document{");
        builder.append("id: ").
                append(documentId).
                append(", name: ").
                append(name).
                append(", type: ").
                append(type).
                append(", location: ").
                append(location).
                append(", description: ").
                append(description).
                append(", created: ").
                append(created).
                append(", modified: ").
                append(modified).append("}");
        return builder.toString();
    }
}
