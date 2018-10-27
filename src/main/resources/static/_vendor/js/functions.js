// function checkUserLogged() {
//     debugger;
//     var user = window.localStorage.getItem('loggedUser');
//     if(user == undefined){
//         document.location = '#/';
//     }
// }

function logOut(options) {
    
    var txt;
    var r = confirm('Are you sure, you want to log out');
    if(r == true){
        //Logout
        window.localStorage.removeItem('loggedUser');
        window.Toasteo.info("Logging out...");
        defaultFunction();

        
    }
    // var deferredObject = $.Deferred();
    // var defaults = {
    //     type: "alert",
    //     modalSizing: "modal-sm",
    //     yesButtonText: "Yes",
    //     cancelButton: "Cancel",
    //     headerText: "Attention",
    //     messageText: "ARe you sure, you want to log out",
    //     alertType: 'default'
    // }
    // $.extend(defaults, options)

    // var _show = function () {
    //     var headClass = 
    // }
}
function ajaxCall(url, type, mydata, dataType) {
    debugger
    if(url === null){
        url = "http://localhost:8080/api/v1/students/"
    }
    if(type == null){
        type = 'GET'
    }
    if(mydata == null){
        mydata = '';
    }
    if (dataType == null) {
        dataType = 'JSON';
    }
    jQuery.ajax({
        url: url,
        type: type,
        data: mydata,
        dataType: dataType,
        crossDomain: true,

        success: function (data) {
            // console.log(data[1].school[0].users);
            debugger
            defaultFunction(data)
        },
        error: function (e) {
            console.log(mydata);
            console.log(e);
            window.Toasteo.error(e.responseText);
        }
    });
}

function defaultFunction(data) {
    debugger
    var loggedUser = $("#userEmail").val();
    setUser();

    // Check logged user
    debugger
    if (data !== undefined) {
        var response = JSON.parse(data);
        if (response.message == 'Success') {
            window.localStorage.setItem('loggedUser', JSON.stringify(response.username));
            window.localStorage.setItem('schoolUser', JSON.stringify(response.school));            
            window.Toasteo.success('Login Credetial approved!');
            
            $('ul.navbar-nav').show();
            document.location = '#/home';
        } else {
            window.Toasteo.error(response.message);
        }
    } else if (JSON.parse(window.localStorage.getItem('loggedUser')) == undefined){
        if(document.location = '#/'){
            window.localStorage.removeItem('loggedUser');
            window.localStorage.removeItem('schoolUser');
            $('ul.navbar-nav').hide();
        } else if (document.location = '#/register'){
            window.localStorage.removeItem('loggedUser');
            window.localStorage.removeItem('schoolUser');
            $('ul.navbar-nav').hide();
        }
    }
}

function setUser(params) {
    var user = JSON.parse(window.localStorage.getItem('loggedUser'));
    var school = JSON.parse(window.localStorage.getItem('schoolUser'));
    if (user != undefined && school != null){
        $("#loggedUser").text(user.toLowerCase());
        $("#schoolName").text(school);
        $("#brand").text(school);
    }else{
        $("#brand").text('eduTrack cPanel');
    }
    
}


function logIn(data) {
    debugger
    var url ="config/login.php";
    var type = "POST";
    var dataType = '';
    ajaxCall(url, type, data,dataType);
}

function register(data) {
    var dataType = ''
    var url = "config/register.php";
    var type = "POST";
    ajaxCall(url, type, data, dataType);
}