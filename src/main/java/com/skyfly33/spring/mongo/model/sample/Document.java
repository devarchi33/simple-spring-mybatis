package com.skyfly33.spring.mongo.model.sample;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by donghoon on 15. 8. 27..
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "documents") // 컬렉션에 저장될 도메인 객체 식별.
public class Document {
//    @Id //저장된 객체를 식별.   ---   MongoDB의 ObjectId 필드에 해당함.
    private String documentId;
    private String name;
    @DBRef // 다른 컬렉션에 대한 레퍼런스 추가.
    private Type type;
    private String location;
    private String description;
    private Date created;
    private Date modified;

    public Document(){
        this(java.util.UUID.randomUUID().toString(),null);
    }
    public Document(String documentId, String name){
        this(documentId,name,null,null,null);
    }
    public Document(String name, String location, String description, Type type){
        this(java.util.UUID.randomUUID().toString(),name,location,description,type);
    }
    public Document(String documentId, String name, String location, String description, Type type){
        Date now = new Date();
        this.documentId = documentId;
        this.name = name;
        this.type = type;
        this.location = location;
        this.description = description;
        this.created = now;
        this.modified = now;
    }

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

    public String toString(){
        StringBuilder builder = new StringBuilder("Document(");
        builder.append("id: ");
        builder.append(documentId);
        builder.append(", name: ");
        builder.append(name);
        builder.append(", type: ");
        builder.append(type);
        builder.append(", location: ");
        builder.append(location);
        builder.append(", created: ");
        builder.append(created);
        builder.append(", modified: ");
        builder.append(modified);
        builder.append(")");
        return builder.toString();
    }
}
