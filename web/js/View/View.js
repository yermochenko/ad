"use strict";

var disciplinePropertyArray = ["Идентификатор","Название","Краткое название"];
var specialtyPropertyArray = ["Название","Код","Дочерние специальности","Короткое название","Квалификация","Идентификатор"];

function hideBlock(id){
    if (document.getElementById(id)) {
        var obj = document.getElementById(id);
        obj.style.display = "none";
    }
    else console.log("Блок не найден!");
}
function unhideBlock(id){
    if (document.getElementById(id)) {
        var obj = document.getElementById(id);
        obj.style.display = "block";
    }
    else console.log("Блок не найден!");
}

function clearDOMElement(id) {
    var container = document.getElementById(id);
    while (container.firstChild) {
        container.removeChild(container.firstChild);
    }
}


function createDisciplineTable(array,url,onclickMethod) {
    clearDOMElement("tableBlock");
    new Table(disciplinePropertyArray,array,"tableBlock").createTable(url,onclickMethod);
}

function createDisciplineForm(object){
    clearDOMElement("form_edit");
    new Form(disciplinePropertyArray,object).getForm();
}

function createSpecialtyTable(array,url,onclickMethod) {
    clearDOMElement("tableBlock");
    new Table(specialtyPropertyArray,array,"tableBlock").createTable(url, onclickMethod);
}

function createSpecialtyForm(object) {
    clearDOMElement("form_edit");
    new Form(specialtyPropertyArray,object).getForm();
}


