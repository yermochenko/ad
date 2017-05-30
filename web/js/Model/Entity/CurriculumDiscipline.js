"use strict";

var CurriculumDiscipline = function (id, curriculum, discipline, semester) {
    Entity.apply(this, arguments);
    this._curriculum = curriculum;
    this._discipline = discipline;
    this._semester = semester;

    this.getCurriculum = function(){
        return this._curriculum;
    };
    this.setCurriculum = function(curriculum){
        this._curriculum = curriculum;
    };

    this.getDiscipline = function(){
        return this._discipline;
    };
    this.setDiscipline = function(discipline){
        this._discipline = discipline;
    };

    this.getSemester = function(){
        return this._semester;
    };
    this.setSemester = function(semester){
        this._semester = semester;
    };
};
CurriculumDiscipline.prototype =  Object.create(Entity);