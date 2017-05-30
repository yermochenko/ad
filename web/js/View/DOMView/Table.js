"use strict";

/*
* Класс предназнаечен для создания и добавляения таблицы в DOM
* Входные параметры:
 * arrayCol - массив названия столбцов
 * json - массив объектов
 * idParentDOM - имя родительского DOM элемента в который будет встраиваться таблица
* */
var Table = function (arrayCol, json, idParentDOM) {
    this._json = json;
    this._arrayCol = arrayCol;
    this._idParentDOM = idParentDOM;

    this.createTable = function (url, onclickMethod) {
        var table = document.createElement("table");
        table.id = "table";
        table.setAttribute("class","table table-striped table-hover");
        var tbody = document.createElement("tbody");
        table.appendChild(tbody);

        //Создание заголовка таблицы
        var tableZagRow = document.createElement('tr');
        for(var i = 0; i < this._arrayCol.length; i++){
            var tempColName = document.createElement('th');
            tempColName.innerHTML = this._arrayCol[i];
            tableZagRow.appendChild(tempColName);
        }
        tbody.appendChild(tableZagRow);

        //Создаем контент
        try{
            var jsonObject = JSON.parse(this._json);

            for(var i = 0; i < jsonObject.length; i++){
                var tr = document.createElement('tr');
                tr.id = jsonObject[i].id;
                for(var property in jsonObject[i]) {
                    var td = document.createElement('td');

                    /*
                    * Если пришел массив элементов
                    * */
                    if(jsonObject[i][property] instanceof Array){
                        for(var j = 0; j < jsonObject[i][property].length; j++){
                            td.appendChild(document.createTextNode("-"));
                            td.appendChild(document.createTextNode(jsonObject[i][property][j].name));
                            td.appendChild(document.createElement('br'));
                        }
                    } else{
                        td.appendChild(document.createTextNode(jsonObject[i][property]));
                    }

                    tr.appendChild(td);
                }
                tr.onclick = function() {
                    var rest = new Rest(url);
                    rest.getById(onclickMethod, this.id);
                };
                tbody.appendChild(tr);
            }

        }catch (ex){
            console.log(ex.message);
        }

        document.getElementById(this._idParentDOM).appendChild(table);
    }

};