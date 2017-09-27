$(document).ready(function () {
    getUser();
});

function getUser() {
    $.ajax({
        url: "Sesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        if (response == "false") {
            window.location.href = "index.html";
        } else {            
            document.getElementById('perfil').innerHTML = '<img src="'+response.imagen+'" alt="NotFound">' + '<br>'
                    + '<p>ID de Usuario: ' + response.identificador + '</p>' + '<br>'
                    + '<p>Nombre: ' + response.nombreSol + '</p>' + '<br>'
                    + '<p>Colegio: ' + response.colegio + '</p>' + '<br>'
                    + '<p>Curso:' + response.cursoArea + '</p>' + '<br>';
        }
    });

}
function closeSesion() {
    $.ajax({
        url: "CloseSesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        if (response == "false") {
            window.location.href = "index.html";
        }
    });

}



