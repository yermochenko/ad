"use strict";

var Entity = function (id) {
    this._id = id;
    this.getId = function () {
        return this._id;
    };
    this.setId = function (id) {
        this._id = id;
    };
};