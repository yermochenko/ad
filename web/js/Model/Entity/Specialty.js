"use strict";

var Specialty = function (id,code,name, shortName, parent, childrens) {
    Entity.apply(this,arguments);
    this._code = code;
    this._name = name;
    this._shortName = shortName;
    this._specialtyDirection = specialtyDirection;
    this._qualification = qualification;
    this._parent = parent;
    this._childrens = childrens;

    this.setCode = function(code){
        this._code = code;
    };
    this.getCode = function () {
      return this._code;
    };

    this.getShortName = function(){
      return this._shortName;
    };
    this.setShortName = function(shortName){
        this._shortName = shortName;
    };

    this.getName = function(){
        return this._name;
    };
    this.setName = function(name){
        this._name = name;
    };

    this.getSpecialtyDirection = function(){
        return this._specialtyDirection;
    };
    this.setSpecialtyDirection = function(specialtyDirection){
        this._specialtyDirection = specialtyDirection;
    };

    this.getQualification = function(){
        return this._qualification;
    };
    this.setQualification = function(qualification){
        this._qualification = qualification;
    };

    this.getParent = function(){
        return this._parent;
    };
    this.setParent = function(parent){
        this._parent = parent;
    };

    this.getChildrens = function(){
        return this._childrens;
    };
    this.setChildrens = function(childrens){
        this._childrens = childrens;
    };

    this.getPropertyNameList = function () {
        return ["Code", "Name", "Short name", "Specialty direction", "Qualification", "Parent specialty", "Childrens specialties"];
    }

};
Specialty.prototype =  Object.create(Entity);
