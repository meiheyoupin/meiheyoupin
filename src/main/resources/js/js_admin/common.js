var baseURL = "/";

/*var token = sessionStorage.getItem("token");
/!*if(token == 'null'){
    parent.location.href = baseURL + 'admin/login.html';
}*!/

$.ajaxSetup({
    dataType: "json",
    cache: false,
    headers: {
        "token": token
    },
    /!*complete: function(xhr) {
        if(xhr.responseJSON.code == 401){
            parent.location.href = baseURL + 'admin/login.html';
        }
    }*!/
});*/

$(function () {
    var token = localStorage.getItem("token");

    console.log(token);
    $.ajaxSetup({
        dataType: "json",
        cache: false,
        headers: {
            "token": token
        },

    });
})