"use strict";

var Curriculum = function (id, year, specialty, curriculumDisciplines) {
    Entity.apply(this,arguments);
    this._year = year;
    this._specialty = specialty;
    this._curriculumDisciplines = curriculumDisciplines;

    this.getYear = function(){
        return this._year;
    };
    this.setYear = function(year){
        this._year = year;
    };

    this.getSpecialty = function(){
        return this._specialty;
    };
    this.setSpecialty = function(specialty){
        this._specialty = specialty;
    };

    this.getCurriculumDisciplines = function(){
        return this._curriculumDisciplines;
    };
    this.setCurriculumDisciplines = function(curriculumDisciplines){
        this._curriculumDisciplines = curriculumDisciplines;
    };
};
Curriculum.prototype =  Object.create(Entity);