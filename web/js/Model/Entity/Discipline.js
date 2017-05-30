"use strict";

var Discipline = function (id,name,shortName) {
    Entity.apply(this, arguments);
    this._name = name;
    this._shortName = shortName;

    this.toString = function () {
        return this._id + "\t" + this._name + "\t" + this._shortName;
    };
    this.getName = function () {
        return this._name;
    };
    this.setName = function (name) {
        this._name = name;
    };
    this.getShortName = function () {
        return this._shortName;
    };
    this.setShortName = function (shortName) {
        this._shortName = shortName;
    };
};
Discipline.prototype =  Object.create(Entity);