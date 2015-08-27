/**
 * Created by donghoon on 15. 8. 27..
 */

var types = {
    "typeId": "",
    "name": "",
    "description": "",
    "extension": ""
}

var documents = {
    "documentId": "",
    "name": "",
    "location": "",
    "description": "",
    "typeId": "",
    "created": "",
    "modified": ""
}

var type1 = {
    "typeId": "41e2d211-6396-4f23-9690-77bc2820d84b",
    "name": "PDF",
    "description": "Protable Document Format",
    "extension": ".pdf"
}

var type2 = {
    "typeId": "e8e5310b-6345-4d08-86b6-d5c3c299aa7f",
    "name": "NOTE",
    "description": "Text Notes",
    "extension": ".txt"
}

var type3 = {
    "typeId": "4980d2e4-a424-4ff4-a0b2-476039682f43",
    "name": "WEB",
    "description": "Web Link",
    "extension": ".url"
}

var type4 = {
    "typeId": "c9f1a16d-852d-4132-b4b8-ead20aafc6ef",
    "name": "WORD",
    "description": "Microsoft Word",
    "extension": ".doc?"
}

var document1 = {
    "documentId": "1acbb68a-a859-49c9-ac88-d9e9322bac55",
    "name": "Book Template",
    "location": "/docs/isfbook/Documents/Random/Book Template.pdf",
    "description": "A book template for creating new books",
    "typeId": "41e2d211-6396-4f23-9690-77bc2820d84b",
    "created": new Date("2014-02-24 11:52"),
    "modified": new Date("2014-02-26 11:52")
}

var document2 = {
    "documentId": "cf7fec3e-55bf-426d-8a6f-2ca752ae34ac",
    "name": "Sample Contract",
    "location": "/docs/isfbook/Documents/Contracts/Sample Contract.pdf",
    "description": "Just a Contract",
    "typeId": "41e2d211-6396-4f23-9690-77bc2820d84b",
    "created": new Date("2013-02-24 11:52"),
    "modified": new Date("2013-07-24 11:52")
}

var document3 = {
    "documentId": "3580f482-7f12-4787-bb60-c98023d47b6c",
    "name": "Clustering with RabbitMQ",
    "location": "/docs/isfbook/Documents/Random/Clustering with RabbitMQ.txt",
    "description": "Simple notes",
    "typeId": "e8e5310b-6345-4d08-86b6-d5c3c299aa7f",
    "created": new Date("2014-02-28 11:52"),
    "modified": new Date("2014-03-24 11:52")
}

var document4 = {
    "documentId": "431cddbf-f3c0-4076-8c1c-564e7dce16c9",
    "name": "Pro Spring Security",
    "location": "http://www.apress.com/9781430248187",
    "description": "Excellent Book",
    "typeId": "4980d2e4-a424-4ff4-a0b2-476039682f43",
    "created": new Date("2014-08-24 12:52"),
    "modified": new Date("2014-09-24 11:52")
}

var document5 = {
    "documentId": "bb633530-20dc-4b46-b320-ff98dc5c3e49",
    "name": "Pro Spring 3",
    "location": "http://www.apress.com/9781430241072",
    "description": "Spring 3 Book",
    "typeId": "4980d2e4-a424-4ff4-a0b2-476039682f43",
    "created": new Date("2014-01-24 11:52"),
    "modified": new Date("2014-02-27 11:52")
}

var document6 = {
    "documentId": "65c28c5a-ce8c-4446-84da-9e44e1525bd0",
    "name": "Bad Book",
    "location": "http://bad.url.com/bad",
    "description": "Bad URL",
    "typeId": "4980d2e4-a424-4ff4-a0b2-476039682f43",
    "created": new Date("2014-02-24 11:12"),
    "modified": new Date("2014-02-25 11:52")
}
