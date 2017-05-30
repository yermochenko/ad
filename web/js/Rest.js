"use strict";

function Rest(url) {
    this.url = url;

    this.getAll = function (onsuccess,urlonclick,onclickmethod) {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', this.url, false);
        xhr.send();
        if (xhr.status != 200) {
            console.log( xhr.status + ': ' + xhr.statusText );
        } else {
            onsuccess(xhr.responseText,urlonclick,onclickmethod);
        }
    };

    this.getById = function (onsuccess, id) {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', this.url + "?id=" + id, false);
        xhr.send();
        if (xhr.status != 200) {
            console.log( xhr.status + ': ' + xhr.statusText );
        } else {
            onsuccess(xhr.responseText);
        }
    };

    this.removeById = function (onsuccess, id) {
        var xhr = new XMLHttpRequest();
        xhr.open('DELETE', this.url + "?id=" + id, false);
        xhr.send();
        console.log(this.url + "?id=" + id);
        if (xhr.status != 200) {
            console.log( xhr.status + ': ' + xhr.statusText );
        } else {
            onsuccess(xhr.responseText);
        }
    };

    this.save = function (object) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', this.url, false);
        xhr.send(JSON.stringify(object));
        if (xhr.status != 200) {
            console.log( xhr.status + ': ' + xhr.statusText );
        } else {
            console.log(xhr.responseText);
        }
    }
}
