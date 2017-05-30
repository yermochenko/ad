"use strict";

window.onload = function(){

    document.getElementById("createTableDiscipline").onclick = function () {
        var rest = new Rest('http://localhost:8080/ad/discipline');
        rest.getAll(createDisciplineTable,'http://localhost:8080/ad/discipline',createDisciplineForm);
    };

    document.getElementById("createTableSpecialty").onclick = function () {
        var rest = new Rest('http://localhost:8080/ad/specialty');
        rest.getAll(createSpecialtyTable,'http://localhost:8080/ad/specialty',createSpecialtyForm);
    };

    document.getElementById("popup_bg").onclick = function () {
        hideBlock("popup");
    };

};


