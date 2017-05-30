"use strict";

var Form = function (propertyNameList,object) {
    this._propertyNameList = propertyNameList;
    this._object = object;
    
    this.getForm = function () {

        var jsonObject = JSON.parse(this._object);

        var form = document.createElement("form");
        form.setAttribute("class","form-horizontal");

        var i = 0;
        for(var property in jsonObject){
            var formGroup = document.createElement("div");
            formGroup.setAttribute("class","form-group");

            var label = document.createElement("label");
            label.setAttribute("for",property);
            label.setAttribute("class","control-label col-sm-2");
            label.innerHTML=this._propertyNameList[i];

            var div = document.createElement("div");
            div.setAttribute("class","col-sm-6");

            var input = document.createElement("input");
            input.setAttribute("type","text");
            input.setAttribute("class","form-control");
            input.setAttribute("id",property);
            input.setAttribute("placeholder","Enter " + property + ": ");

            input.setAttribute("value",jsonObject[property]);

            div.appendChild(input);

            formGroup.appendChild(label);
            formGroup.appendChild(div);
            form.appendChild(formGroup);

            i++;
        }

        var div = document.createElement("div");
        div.setAttribute("class","col-sm-2");

        var buttonDelete = document.createElement("button");
        buttonDelete.setAttribute("class","btn btn-default");
        buttonDelete.innerHTML = "Удалить";
        buttonDelete.onclick = function() {
            var rest = new Rest('http://localhost:8080/ad/discipline');
            rest.removeById(alert, jsonObject["id"]);
        };

        var button = document.createElement("button");
        //button.setAttribute("type", "submit");
        button.setAttribute("class","btn btn-default");
        button.innerHTML = "Сохранить";
        button.onclick = function() {
            for(var property in jsonObject) {
                if(property!="id") {
                    jsonObject[property] = document.getElementById(property).value;
                }
            }
            var rest = new Rest('http://localhost:8080/ad/discipline');
            rest.save(jsonObject);
        };


        div.appendChild(buttonDelete);
        div.appendChild(button);

        form.appendChild(div);

        unhideBlock("popup");
        document.getElementById("form_edit").appendChild(form);
    }
    
};