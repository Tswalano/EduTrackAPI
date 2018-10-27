(function ($) {
    var app = $.sammy('#main', function () {
        this.debug = true;
        var form_fields = null;

        this.get('#/', function () {
            this.partial('routes/login.tamplate.php');
        });

        this.get('#/login', function () {
            this.partial('routes/login.tamplate.php');
        });

        this.get('#/home', function () {
            this.partial('routes/home.tamplate.php');
        });

        this.get('#/register', function () {
            this.partial('routes/register.tamplate.php');
        });

        this.get('#/about', function () {
            this.partial('routes/about.tamplate.php');
        });

        this.get('#/info', function () {
            this.partial('routes/info.tamplate.php');
        });

        this.get('#/add-student', function () {
            this.partial('routes/add-student.tamplate.php');
        });

        this.get('#/waiting', function () {
            this.partial('routes/waiting-list.tamplate.php');
        });

        this.get('#/logout', function () {
            this.partial('logout.php');
        });

    });

    $(function () {
        app.run('#/');
    });

})(jQuery);