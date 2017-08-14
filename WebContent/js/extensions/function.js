$(function comprobrarClave() {
    $('#contrasena').keyup(function () {
        var _this = $('#contrasena');
        var contrasenaNueva = $('#contrasena').val();
        console.log("Lo que va: " + contrasenaNueva);
        _this.attr('style', 'background:white');
        if (contrasenaNueva.charAt(0) == ' ') {
            _this.attr('style', 'background:#FF4A4A');
        }

        if (contrasenaNueva.val() == '') {
            _this.attr('style', 'background:#FF4A4A');
        }
    });

    $('#confirmarContrasena').keyup(function () {
        var contrasenaNueva = $('#contrasena').val();
        var confirmarContrasena = $('#confirmarContrasena').val();
        var _this = $('#confirmarContrasena');
        _this.attr('style', 'background:white');
        if (contrasenaNueva != confirmarContrasena && confirmarContrasena != '') {
            _this.attr('style', 'background:#ef9a9a ');
            return false;
        } else {
            if (confirmarContrasena == '') {
                _this.attr('style', 'background:white ');
            } else {
                _this.attr('style', 'background:#e8f5e9  ');
            }

        }
    });
});





